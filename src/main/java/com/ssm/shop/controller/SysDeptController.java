package com.ssm.shop.controller;

import java.util.List;

import com.ssm.shop.http.HttpResult;
import com.ssm.shop.pojo.SysDept;
import com.ssm.shop.service.inter.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 机构控制器
 * @author Louis
 * @date Oct 29, 2018
 */
@RestController
@RequestMapping("dept")
public class SysDeptController {

	@Autowired
	private SysDeptService sysDeptService;

	@RequestMapping(value="/save")
	public HttpResult save(@RequestBody SysDept record) {
		return HttpResult.ok(sysDeptService.save(record));
	}

	@RequestMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysDept> records) {
		return HttpResult.ok(sysDeptService.delete(records));
	}

	@RequestMapping(value="/findTree")
	public HttpResult findTree(SysDept dept) {
		return HttpResult.ok(sysDeptService.findTree(dept));
	}

}
