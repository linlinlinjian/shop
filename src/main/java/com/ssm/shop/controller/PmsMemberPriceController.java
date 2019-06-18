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
import com.ssm.shop.pojo.PmsMemberPrice;
import com.ssm.shop.service.inter.PmsMemberPriceService;


@RestController
@RequestMapping("/pmsMemberPrice")
public class PmsMemberPriceController {

	@Autowired
	private PmsMemberPriceService pmsMemberPriceService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",pmsMemberPriceService.getPmsMemberPrice(id));
		}

	}

	@RequestMapping("/listPmsMemberPriceByPage")
	public @ResponseBody HttpResult listPmsMemberPriceByPage(PmsMemberPrice pmsMemberPrice){

		return HttpResult.ok(pmsMemberPriceService.listPmsMemberPriceByPage(pmsMemberPrice));
	}

	@RequestMapping("/insertPmsMemberPrice")
	public @ResponseBody HttpResult insertPmsMemberPrice(PmsMemberPrice pmsMemberPrice){

		pmsMemberPriceService.savePmsMemberPrice(pmsMemberPrice);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updatePmsMemberPrice")
	public @ResponseBody HttpResult updatePmsMemberPrice(PmsMemberPrice pmsMemberPrice){

		pmsMemberPriceService.updatePmsMemberPrice(pmsMemberPrice);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deletePmsMemberPrice")
	public @ResponseBody HttpResult deletePmsMemberPrice(int id){

		pmsMemberPriceService.deletePmsMemberPrice(id);

		return HttpResult.ok("删除成功");
	}

}