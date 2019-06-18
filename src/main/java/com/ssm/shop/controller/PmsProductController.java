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
import com.ssm.shop.pojo.PmsProduct;
import com.ssm.shop.service.inter.PmsProductService;


@RestController
@RequestMapping("/pmsProduct")
public class PmsProductController {

	@Autowired
	private PmsProductService pmsProductService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",pmsProductService.getPmsProduct(id));
		}

	}

	@RequestMapping("/listPmsProductByPage")
	public @ResponseBody HttpResult listPmsProductByPage(PmsProduct pmsProduct){

		return HttpResult.ok(pmsProductService.listPmsProductByPage(pmsProduct));
	}

	@RequestMapping("/insertPmsProduct")
	public @ResponseBody HttpResult insertPmsProduct(@RequestBody PmsProduct pmsProduct){
        System.out.println(pmsProduct.toString());
		pmsProductService.savePmsProduct(pmsProduct);


		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updatePmsProduct")
	public @ResponseBody HttpResult updatePmsProduct(PmsProduct pmsProduct){

		pmsProductService.updatePmsProduct(pmsProduct);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deletePmsProduct")
	public @ResponseBody HttpResult deletePmsProduct(int id){

		pmsProductService.deletePmsProduct(id);

		return HttpResult.ok("删除成功");
	}

}