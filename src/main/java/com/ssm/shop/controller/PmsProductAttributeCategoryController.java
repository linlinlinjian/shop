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
import com.ssm.shop.pojo.PmsProductAttributeCategory;
import com.ssm.shop.service.inter.PmsProductAttributeCategoryService;


@RestController
@RequestMapping("/pmsProductAttributeCategory")
public class PmsProductAttributeCategoryController {

	@Autowired
	private PmsProductAttributeCategoryService pmsProductAttributeCategoryService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",pmsProductAttributeCategoryService.getPmsProductAttributeCategory(id));
		}

	}

	@RequestMapping("/listPmsProductAttributeCategoryByPage")
	public @ResponseBody HttpResult listPmsProductAttributeCategoryByPage(PmsProductAttributeCategory pmsProductAttributeCategory){

		return HttpResult.ok(pmsProductAttributeCategoryService.listPmsProductAttributeCategoryByPage(pmsProductAttributeCategory));
	}

	@RequestMapping("/insertPmsProductAttributeCategory")
	public @ResponseBody HttpResult insertPmsProductAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory){

		pmsProductAttributeCategoryService.savePmsProductAttributeCategory(pmsProductAttributeCategory);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updatePmsProductAttributeCategory")
	public @ResponseBody HttpResult updatePmsProductAttributeCategory( PmsProductAttributeCategory pmsProductAttributeCategory){

		pmsProductAttributeCategoryService.updatePmsProductAttributeCategory(pmsProductAttributeCategory);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deletePmsProductAttributeCategory")
	public @ResponseBody HttpResult deletePmsProductAttributeCategory(int id){

		pmsProductAttributeCategoryService.deletePmsProductAttributeCategory(id);

		return HttpResult.ok("删除成功");
	}

}