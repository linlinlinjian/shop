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
import com.ssm.shop.pojo.CmsSubjectComment;
import com.ssm.shop.service.inter.CmsSubjectCommentService;


@RestController
@RequestMapping("/cmsSubjectComment")
public class CmsSubjectCommentController {

	@Autowired
	private CmsSubjectCommentService cmsSubjectCommentService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",cmsSubjectCommentService.getCmsSubjectComment(id));
		}

	}

	@RequestMapping("/listCmsSubjectCommentByPage")
	public @ResponseBody HttpResult listCmsSubjectCommentByPage(CmsSubjectComment cmsSubjectComment){

		return HttpResult.ok(cmsSubjectCommentService.listCmsSubjectCommentByPage(cmsSubjectComment));
	}

	@RequestMapping("/insertCmsSubjectComment")
	public @ResponseBody HttpResult insertCmsSubjectComment(CmsSubjectComment cmsSubjectComment){

		cmsSubjectCommentService.saveCmsSubjectComment(cmsSubjectComment);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updateCmsSubjectComment")
	public @ResponseBody HttpResult updateCmsSubjectComment(CmsSubjectComment cmsSubjectComment){

		cmsSubjectCommentService.updateCmsSubjectComment(cmsSubjectComment);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deleteCmsSubjectComment")
	public @ResponseBody HttpResult deleteCmsSubjectComment(int id){

		cmsSubjectCommentService.deleteCmsSubjectComment(id);

		return HttpResult.ok("删除成功");
	}

}