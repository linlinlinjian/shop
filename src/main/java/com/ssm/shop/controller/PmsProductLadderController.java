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
import com.ssm.shop.pojo.PmsProductLadder;
import com.ssm.shop.service.inter.PmsProductLadderService;


@RestController
@RequestMapping("/pmsProductLadder")
public class PmsProductLadderController {

	@Autowired
	private PmsProductLadderService pmsProductLadderService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",pmsProductLadderService.getPmsProductLadder(id));
		}

	}

	@RequestMapping("/listPmsProductLadderByPage")
	public @ResponseBody HttpResult listPmsProductLadderByPage(PmsProductLadder pmsProductLadder){

		return HttpResult.ok(pmsProductLadderService.listPmsProductLadderByPage(pmsProductLadder));
	}

	@RequestMapping("/insertPmsProductLadder")
	public @ResponseBody HttpResult insertPmsProductLadder(PmsProductLadder pmsProductLadder){

		pmsProductLadderService.savePmsProductLadder(pmsProductLadder);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updatePmsProductLadder")
	public @ResponseBody HttpResult updatePmsProductLadder(PmsProductLadder pmsProductLadder){

		pmsProductLadderService.updatePmsProductLadder(pmsProductLadder);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deletePmsProductLadder")
	public @ResponseBody HttpResult deletePmsProductLadder(int id){

		pmsProductLadderService.deletePmsProductLadder(id);

		return HttpResult.ok("删除成功");
	}

}