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
import com.ssm.shop.pojo.PmsProductFullReduction;
import com.ssm.shop.service.inter.PmsProductFullReductionService;


@RestController
@RequestMapping("/pmsProductFullReduction")
public class PmsProductFullReductionController {

	@Autowired
	private PmsProductFullReductionService pmsProductFullReductionService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",pmsProductFullReductionService.getPmsProductFullReduction(id));
		}

	}

	@RequestMapping("/listPmsProductFullReductionByPage")
	public @ResponseBody HttpResult listPmsProductFullReductionByPage(PmsProductFullReduction pmsProductFullReduction){

		return HttpResult.ok(pmsProductFullReductionService.listPmsProductFullReductionByPage(pmsProductFullReduction));
	}

	@RequestMapping("/insertPmsProductFullReduction")
	public @ResponseBody HttpResult insertPmsProductFullReduction(PmsProductFullReduction pmsProductFullReduction){

		pmsProductFullReductionService.savePmsProductFullReduction(pmsProductFullReduction);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updatePmsProductFullReduction")
	public @ResponseBody HttpResult updatePmsProductFullReduction(PmsProductFullReduction pmsProductFullReduction){

		pmsProductFullReductionService.updatePmsProductFullReduction(pmsProductFullReduction);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deletePmsProductFullReduction")
	public @ResponseBody HttpResult deletePmsProductFullReduction(int id){

		pmsProductFullReductionService.deletePmsProductFullReduction(id);

		return HttpResult.ok("删除成功");
	}

}