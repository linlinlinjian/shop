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
import com.ssm.shop.pojo.CmsSubject;
import com.ssm.shop.service.inter.CmsSubjectService;


@RestController
@RequestMapping("/cmsSubject")
public class CmsSubjectController {

	@Autowired
	private CmsSubjectService cmsSubjectService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",cmsSubjectService.getCmsSubject(id));
		}

	}

	@RequestMapping("/listCmsSubjectByPage")
	public @ResponseBody HttpResult listCmsSubjectByPage(CmsSubject cmsSubject){

		return HttpResult.ok(cmsSubjectService.listCmsSubjectByPage(cmsSubject));
	}

	@RequestMapping("/insertCmsSubject")
	public @ResponseBody HttpResult insertCmsSubject(CmsSubject cmsSubject){

		cmsSubjectService.saveCmsSubject(cmsSubject);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updateCmsSubject")
	public @ResponseBody HttpResult updateCmsSubject(CmsSubject cmsSubject){

		cmsSubjectService.updateCmsSubject(cmsSubject);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deleteCmsSubject")
	public @ResponseBody HttpResult deleteCmsSubject(int id){

		cmsSubjectService.deleteCmsSubject(id);

		return HttpResult.ok("删除成功");
	}

}