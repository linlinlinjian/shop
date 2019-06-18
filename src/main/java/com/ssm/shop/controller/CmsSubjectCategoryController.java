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
import com.ssm.shop.pojo.CmsSubjectCategory;
import com.ssm.shop.service.inter.CmsSubjectCategoryService;


@RestController
@RequestMapping("/cmsSubjectCategory")
public class CmsSubjectCategoryController {

	@Autowired
	private CmsSubjectCategoryService cmsSubjectCategoryService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",cmsSubjectCategoryService.getCmsSubjectCategory(id));
		}

	}

	@RequestMapping("/listCmsSubjectCategoryByPage")
	public @ResponseBody HttpResult listCmsSubjectCategoryByPage(CmsSubjectCategory cmsSubjectCategory){

		return HttpResult.ok(cmsSubjectCategoryService.listCmsSubjectCategoryByPage(cmsSubjectCategory));
	}

	@RequestMapping("/insertCmsSubjectCategory")
	public @ResponseBody HttpResult insertCmsSubjectCategory(CmsSubjectCategory cmsSubjectCategory){

		cmsSubjectCategoryService.saveCmsSubjectCategory(cmsSubjectCategory);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updateCmsSubjectCategory")
	public @ResponseBody HttpResult updateCmsSubjectCategory(CmsSubjectCategory cmsSubjectCategory){

		cmsSubjectCategoryService.updateCmsSubjectCategory(cmsSubjectCategory);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deleteCmsSubjectCategory")
	public @ResponseBody HttpResult deleteCmsSubjectCategory(int id){

		cmsSubjectCategoryService.deleteCmsSubjectCategory(id);

		return HttpResult.ok("删除成功");
	}

}