package com.ssm.shop.controller;

import java.util.List;
import com.ssm.shop.util.StringTool;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import com.ssm.shop.http.HttpResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssm.shop.pojo.UmsMember;
import com.ssm.shop.service.inter.UmsMemberService;


@RestController
@RequestMapping("/umsMember")
public class UmsMemberController {

	@Autowired
	private UmsMemberService umsMemberService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",umsMemberService.getUmsMember(id));
		}

	}

	@RequestMapping("/listUmsMemberByPage")
	public @ResponseBody HttpResult listUmsMemberByPage(UmsMember umsMember){

		return HttpResult.ok(umsMemberService.listUmsMemberByPage(umsMember));
	}

	@RequestMapping("/insertUmsMember")
	public @ResponseBody HttpResult insertUmsMember(UmsMember umsMember){

		umsMemberService.saveUmsMember(umsMember);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updateUmsMember")
	public @ResponseBody HttpResult updateUmsMember(UmsMember umsMember){

		umsMemberService.updateUmsMember(umsMember);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deleteUmsMember")
	public @ResponseBody HttpResult deleteUmsMember(int id){

		umsMemberService.deleteUmsMember(id);

		return HttpResult.ok("删除成功");
	}

	@RequestMapping("/login")
	public @ResponseBody HttpResult login(UmsMember member) {

		UmsMember login = umsMemberService.login(member);
		if(login==null){
			return HttpResult.error("账号或密码错误");
		}else{
			return HttpResult.ok("登录成功",login);
		}

	}

}