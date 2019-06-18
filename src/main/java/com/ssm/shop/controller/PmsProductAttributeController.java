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
import com.ssm.shop.pojo.PmsProductAttribute;
import com.ssm.shop.service.inter.PmsProductAttributeService;


@RestController
@RequestMapping("/pmsProductAttribute")
public class PmsProductAttributeController {

	@Autowired
	private PmsProductAttributeService pmsProductAttributeService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",pmsProductAttributeService.getPmsProductAttribute(id));
		}

	}

	@RequestMapping("/listPmsProductAttributeByPage")
	public @ResponseBody HttpResult listPmsProductAttributeByPage(PmsProductAttribute pmsProductAttribute){

		return HttpResult.ok(pmsProductAttributeService.listPmsProductAttributeByPage(pmsProductAttribute));
	}

	@RequestMapping("/insertPmsProductAttribute")
	public @ResponseBody HttpResult insertPmsProductAttribute(PmsProductAttribute pmsProductAttribute){

		pmsProductAttributeService.savePmsProductAttribute(pmsProductAttribute);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updatePmsProductAttribute")
	public @ResponseBody HttpResult updatePmsProductAttribute(PmsProductAttribute pmsProductAttribute){

		pmsProductAttributeService.updatePmsProductAttribute(pmsProductAttribute);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deletePmsProductAttribute")
	public @ResponseBody HttpResult deletePmsProductAttribute(int id){

		pmsProductAttributeService.deletePmsProductAttribute(id);

		return HttpResult.ok("删除成功");
	}

}