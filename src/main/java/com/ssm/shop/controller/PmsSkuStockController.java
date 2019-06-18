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
import com.ssm.shop.pojo.PmsSkuStock;
import com.ssm.shop.service.inter.PmsSkuStockService;


@RestController
@RequestMapping("/pmsSkuStock")
public class PmsSkuStockController {

	@Autowired
	private PmsSkuStockService pmsSkuStockService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",pmsSkuStockService.getPmsSkuStock(id));
		}

	}

	@RequestMapping("/listPmsSkuStockByPage")
	public @ResponseBody HttpResult listPmsSkuStockByPage(PmsSkuStock pmsSkuStock){

		return HttpResult.ok(pmsSkuStockService.listPmsSkuStockByPage(pmsSkuStock));
	}

	@RequestMapping("/insertPmsSkuStock")
	public @ResponseBody HttpResult insertPmsSkuStock(PmsSkuStock pmsSkuStock){

		pmsSkuStockService.savePmsSkuStock(pmsSkuStock);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updatePmsSkuStock")
	public @ResponseBody HttpResult updatePmsSkuStock(PmsSkuStock pmsSkuStock){

		pmsSkuStockService.updatePmsSkuStock(pmsSkuStock);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deletePmsSkuStock")
	public @ResponseBody HttpResult deletePmsSkuStock(int id){

		pmsSkuStockService.deletePmsSkuStock(id);

		return HttpResult.ok("删除成功");
	}

}