package com.ssm.shop.controller;

import java.util.List;
import com.ssm.shop.util.StringTool;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import com.ssm.shop.http.HttpResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssm.shop.pojo.PmsBrand;
import com.ssm.shop.service.inter.PmsBrandService;


@RestController
@RequestMapping("/pmsBrand")
public class PmsBrandController {

	@Autowired
	private PmsBrandService pmsBrandService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(@RequestBody int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",pmsBrandService.getPmsBrand(id));
		}

	}

	@RequestMapping("/listPmsBrandByPage")
	public @ResponseBody HttpResult listPmsBrandByPage(PmsBrand pmsBrand){

		return HttpResult.ok(pmsBrandService.listPmsBrandByPage(pmsBrand));
	}

	@RequestMapping("/insertPmsBrand")
	public @ResponseBody HttpResult insertPmsBrand(@RequestBody PmsBrand pmsBrand){

		pmsBrandService.savePmsBrand(pmsBrand);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updatePmsBrand")
	public @ResponseBody HttpResult updatePmsBrand(@RequestBody PmsBrand pmsBrand){

		pmsBrandService.updatePmsBrand(pmsBrand);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deletePmsBrand")
	public @ResponseBody HttpResult deletePmsBrand(@RequestBody long id){

		pmsBrandService.deletePmsBrand(id);

		return HttpResult.ok("删除成功");
	}

}