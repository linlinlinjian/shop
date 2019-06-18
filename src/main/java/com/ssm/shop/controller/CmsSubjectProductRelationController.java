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
import com.ssm.shop.pojo.CmsSubjectProductRelation;
import com.ssm.shop.service.inter.CmsSubjectProductRelationService;


@RestController
@RequestMapping("/cmsSubjectProductRelation")
public class CmsSubjectProductRelationController {

	@Autowired
	private CmsSubjectProductRelationService cmsSubjectProductRelationService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",cmsSubjectProductRelationService.getCmsSubjectProductRelation(id));
		}

	}

	@RequestMapping("/listCmsSubjectProductRelationByPage")
	public @ResponseBody HttpResult listCmsSubjectProductRelationByPage(CmsSubjectProductRelation cmsSubjectProductRelation){

		return HttpResult.ok(cmsSubjectProductRelationService.listCmsSubjectProductRelationByPage(cmsSubjectProductRelation));
	}

	@RequestMapping("/insertCmsSubjectProductRelation")
	public @ResponseBody HttpResult insertCmsSubjectProductRelation(CmsSubjectProductRelation cmsSubjectProductRelation){

		cmsSubjectProductRelationService.saveCmsSubjectProductRelation(cmsSubjectProductRelation);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updateCmsSubjectProductRelation")
	public @ResponseBody HttpResult updateCmsSubjectProductRelation(CmsSubjectProductRelation cmsSubjectProductRelation){

		cmsSubjectProductRelationService.updateCmsSubjectProductRelation(cmsSubjectProductRelation);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deleteCmsSubjectProductRelation")
	public @ResponseBody HttpResult deleteCmsSubjectProductRelation(int id){

		cmsSubjectProductRelationService.deleteCmsSubjectProductRelation(id);

		return HttpResult.ok("删除成功");
	}

}