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
import com.ssm.shop.pojo.PmsProductAttributeValue;
import com.ssm.shop.service.inter.PmsProductAttributeValueService;


@RestController
@RequestMapping("/pmsProductAttributeValue")
public class PmsProductAttributeValueController {

	@Autowired
	private PmsProductAttributeValueService pmsProductAttributeValueService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",pmsProductAttributeValueService.getPmsProductAttributeValue(id));
		}

	}

	@RequestMapping("/listPmsProductAttributeValueByPage")
	public @ResponseBody HttpResult listPmsProductAttributeValueByPage(PmsProductAttributeValue pmsProductAttributeValue){

		return HttpResult.ok(pmsProductAttributeValueService.listPmsProductAttributeValueByPage(pmsProductAttributeValue));
	}

	@RequestMapping("/insertPmsProductAttributeValue")
	public @ResponseBody HttpResult insertPmsProductAttributeValue(PmsProductAttributeValue pmsProductAttributeValue){

		pmsProductAttributeValueService.savePmsProductAttributeValue(pmsProductAttributeValue);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updatePmsProductAttributeValue")
	public @ResponseBody HttpResult updatePmsProductAttributeValue(PmsProductAttributeValue pmsProductAttributeValue){

		pmsProductAttributeValueService.updatePmsProductAttributeValue(pmsProductAttributeValue);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deletePmsProductAttributeValue")
	public @ResponseBody HttpResult deletePmsProductAttributeValue(int id){

		pmsProductAttributeValueService.deletePmsProductAttributeValue(id);

		return HttpResult.ok("删除成功");
	}

}