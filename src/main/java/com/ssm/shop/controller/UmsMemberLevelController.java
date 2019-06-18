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
import com.ssm.shop.pojo.UmsMemberLevel;
import com.ssm.shop.service.inter.UmsMemberLevelService;


@RestController
@RequestMapping("/umsMemberLevel")
public class UmsMemberLevelController {

	@Autowired
	private UmsMemberLevelService umsMemberLevelService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",umsMemberLevelService.getUmsMemberLevel(id));
		}

	}

	@RequestMapping("/listUmsMemberLevelByPage")
	public @ResponseBody HttpResult listUmsMemberLevelByPage(UmsMemberLevel umsMemberLevel){

		return HttpResult.ok(umsMemberLevelService.listUmsMemberLevelByPage(umsMemberLevel));
	}

	@RequestMapping("/insertUmsMemberLevel")
	public @ResponseBody HttpResult insertUmsMemberLevel(UmsMemberLevel umsMemberLevel){

		umsMemberLevelService.saveUmsMemberLevel(umsMemberLevel);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updateUmsMemberLevel")
	public @ResponseBody HttpResult updateUmsMemberLevel(UmsMemberLevel umsMemberLevel){

		umsMemberLevelService.updateUmsMemberLevel(umsMemberLevel);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deleteUmsMemberLevel")
	public @ResponseBody HttpResult deleteUmsMemberLevel(int id){

		umsMemberLevelService.deleteUmsMemberLevel(id);

		return HttpResult.ok("删除成功");
	}

}