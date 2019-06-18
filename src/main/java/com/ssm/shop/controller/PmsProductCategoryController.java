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
import com.ssm.shop.pojo.PmsProductCategory;
import com.ssm.shop.service.inter.PmsProductCategoryService;


@RestController
@RequestMapping("/pmsProductCategory")
public class PmsProductCategoryController {

	@Autowired
	private PmsProductCategoryService pmsProductCategoryService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",pmsProductCategoryService.getPmsProductCategory(id));
		}

	}

	@RequestMapping("/listPmsProductCategoryByPage")
	public @ResponseBody HttpResult listPmsProductCategoryByPage(PmsProductCategory pmsProductCategory){

		return HttpResult.ok(pmsProductCategoryService.findTree(pmsProductCategory));
	}

	@RequestMapping("/insertPmsProductCategory")
	public @ResponseBody HttpResult insertPmsProductCategory(@RequestBody PmsProductCategory pmsProductCategory){

		pmsProductCategoryService.savePmsProductCategory(pmsProductCategory);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updatePmsProductCategory")
	public @ResponseBody HttpResult updatePmsProductCategory(PmsProductCategory pmsProductCategory){

		pmsProductCategoryService.updatePmsProductCategory(pmsProductCategory);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deletePmsProductCategory")
	public @ResponseBody HttpResult deletePmsProductCategory(@RequestBody String ids){
		String[] split = ids.split(",");
		for(int i=0;i<split.length;i++){
			pmsProductCategoryService.deletePmsProductCategory(Long.valueOf(split[i]));
		}

		return HttpResult.ok("删除成功");
	}

}