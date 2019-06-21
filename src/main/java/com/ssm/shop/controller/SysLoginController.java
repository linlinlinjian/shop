package com.ssm.shop.controller;

import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssm.shop.http.HttpResult;
import com.ssm.shop.pojo.SysUser;
import com.ssm.shop.service.inter.JedisClientService;
import com.ssm.shop.service.inter.SysUserService;
import com.ssm.shop.util.CookieUtils;
import com.ssm.shop.util.IOUtils;
import com.ssm.shop.util.JsonUtils;
import com.ssm.shop.util.PasswordUtils;
import com.ssm.shop.vo.LoginBean;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import com.google.code.kaptcha.Constants;

/**
 * 登录控制器
 * @author Louis
 * @date Oct 29, 2018
 */
@RestController
@PropertySource(value = "classpath:redis.properties")
public class SysLoginController {


	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private JedisClientService jedisClient;

	@Value("${REDIS_USER_SESSION_KEY}")
	private String REDIS_USER_SESSION_KEY;

	@Value("${SSO_SESSION_EXPIRE}")
	private Integer SSO_SESSION_EXPIRE;

	@GetMapping("captcha.jpg")
	public void captcha(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

//		// 生成文字验证码
//		String text = producer.createText();
//		// 生成图片验证码
//		BufferedImage image = producer.createImage(text);
		// 保存到验证码到 session
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, "0020");

		ServletOutputStream out = response.getOutputStream();
		//ImageIO.write(null, "jpg", out);
		IOUtils.closeQuietly(out);
	}

	/**
	 * 登录接口
	 */
	@RequestMapping(value = "/login")
	public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = loginBean.getAccount();
		String password = loginBean.getPassword();
		String captcha = loginBean.getCaptcha();
		
		// 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
		//Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
//		if(kaptcha == null){
//			return HttpResult.error("验证码已失效");
//		}
//		if(!captcha.equals(kaptcha)){
//			return HttpResult.error("验证码不正确");
//		}
		
		// 用户信息
		SysUser user = sysUserService.findByName(username);

		// 账号不存在、密码错误
		if (user == null) {
			return HttpResult.error("账号不存在");
		}
		
		if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
			return HttpResult.error("密码不正确");
		}

		// 账号锁定
		if (user.getStatus() == 0) {
			return HttpResult.error("账号已被锁定,请联系管理员");
		}
		String token = UUID.randomUUID().toString();
		// 清空密码和盐避免泄漏
		String userPassword = user.getPassword();
		String userSalt = user.getSalt();
		user.setPassword(null);
		user.setSalt(null);
		// 把用户信息写入 redis
		String set = jedisClient.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
		System.out.println(set);
		// user 已经是持久化对象，被保存在session缓存当中，若user又重新修改属性值，那么在提交事务时，此时 hibernate对象就会拿当前这个user对象和保存在session缓存中的user对象进行比较，如果两个对象相同，则不会发送update语句，否则会发出update语句。
		user.setPassword(userPassword);
		user.setSalt(userSalt);
		// 设置 session 的过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
		// 添加写 cookie 的逻辑，cookie 的有效期是关闭浏览器就失效。
		CookieUtils.setCookie(request, response, "USER_TOKEN", token);
		// 系统登录认证
		//JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
		System.out.println(token);
		return HttpResult.ok(token);
	}

	@RequestMapping(value="/logout/{token}")
	public String logout(@PathVariable String token) {
		sysUserService.loginOut(token); // 思路是从Redis中删除key，实际情况请和业务逻辑结合
		return "index";
	}



	@RequestMapping("/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable String token) {
		HttpResult result = null;
		try {
			result = sysUserService.queryUserByToken(token);
		} catch (Exception e) {
			e.printStackTrace();
			result = HttpResult.error(500, "");
		}
		return result;
	}

	@RequestMapping(value="test")
	public String test() {
		String set = jedisClient.set("aa", "ccc");
		System.out.println(set);
		return set;
	}
}
