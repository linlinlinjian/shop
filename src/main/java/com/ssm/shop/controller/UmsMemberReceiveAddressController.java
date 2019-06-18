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
import com.ssm.shop.pojo.UmsMemberReceiveAddress;
import com.ssm.shop.service.inter.UmsMemberReceiveAddressService;


@RestController
@RequestMapping("/umsMemberReceiveAddress")
public class UmsMemberReceiveAddressController {

	@Autowired
	private UmsMemberReceiveAddressService umsMemberReceiveAddressService;

	@RequestMapping("/getById")
	public @ResponseBody HttpResult getById(int id) {

		if(StringTool.isEmpty(String.valueOf(id))){
		return HttpResult.error("id不能为空!");
		}else {
		return HttpResult.ok("显示成功",umsMemberReceiveAddressService.getUmsMemberReceiveAddress(id));
		}

	}

	@RequestMapping("/listUmsMemberReceiveAddressByPage")
	public @ResponseBody HttpResult listUmsMemberReceiveAddressByPage(UmsMemberReceiveAddress umsMemberReceiveAddress){

		return HttpResult.ok(umsMemberReceiveAddressService.listUmsMemberReceiveAddressByPage(umsMemberReceiveAddress));
	}

	@RequestMapping("/insertUmsMemberReceiveAddress")
	public @ResponseBody HttpResult insertUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress){

		umsMemberReceiveAddressService.saveUmsMemberReceiveAddress(umsMemberReceiveAddress);

		return HttpResult.ok("添加成功");
	}

	@RequestMapping("/updateUmsMemberReceiveAddress")
	public @ResponseBody HttpResult updateUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress){

		umsMemberReceiveAddressService.updateUmsMemberReceiveAddress(umsMemberReceiveAddress);

		return HttpResult.ok("修改成功");
	}

	@RequestMapping("/deleteUmsMemberReceiveAddress")
	public @ResponseBody HttpResult deleteUmsMemberReceiveAddress(int id){

		umsMemberReceiveAddressService.deleteUmsMemberReceiveAddress(id);

		return HttpResult.ok("删除成功");
	}

}