package com.ssm.shop.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;

import com.ssm.shop.pojo.SysDept;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.PmsProductCategoryMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsProductCategory;
import com.ssm.shop.service.inter.PmsProductCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {

	@Autowired
	private PmsProductCategoryMapper PmsProductCategoryMapper;

	@Override
	public List<PmsProductCategory> listPmsProductCategory(PmsProductCategory record){

		return null;

	}

	@Override
	public PageResult listPmsProductCategoryByPage(PmsProductCategory record){

		int total = PmsProductCategoryMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<PmsProductCategory> rows=PmsProductCategoryMapper.listPmsProductCategoryByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public PageResult findTree(PmsProductCategory pmsProductCategory) {
		List<PmsProductCategory> products = new ArrayList<>();
		//pmsProductCategory.setLevel(0);
		//int total = PmsProductCategoryMapper.selectCount(pmsProductCategory);
		pmsProductCategory.setCurrentPage((pmsProductCategory.getCurrentPage()-1)*pmsProductCategory.getPageSize());
		List<PmsProductCategory> pro = PmsProductCategoryMapper.listPmsProductCategoryByPage(pmsProductCategory);
		for (PmsProductCategory p:pro ) {
			if(p.getParentId()==0 && p.getLevel()==0){
				products.add(p);
			}
		}
		findChildren(products,pro);
		return new PageResult(pmsProductCategory.getCurrentPage()+1,pmsProductCategory.getPageSize(),products.size(),products);
	}

	private void findChildren(List<PmsProductCategory> sysDepts, List<PmsProductCategory> depts) {
		for (PmsProductCategory sysDept : sysDepts) {
			List<PmsProductCategory> children = new ArrayList<>();
			for (PmsProductCategory dept : depts) {
				if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())) {
					dept.setParentName(sysDept.getName());
					dept.setLevel(sysDept.getLevel() + 1);
					children.add(dept);
				}
			}
			sysDept.setChildren(children);
			findChildren(children, depts);
		}
	}

	@Override
	public int selectCount(PmsProductCategory record){

		return 0;

	}

	@Override
	public void savePmsProductCategory(PmsProductCategory pmsProductCategory){
		if(pmsProductCategory.getId()==null || pmsProductCategory.getId()==0){
			PmsProductCategoryMapper.insert(pmsProductCategory);
		}else{
			PmsProductCategoryMapper.updateByPrimaryKey(pmsProductCategory);
		}

	}

	@Override
	public PmsProductCategory getPmsProductCategory(long id){
		return PmsProductCategoryMapper.selectByPrimaryKey(id);	}

	@Override
	public void updatePmsProductCategory(PmsProductCategory pmsProductCategory){
		PmsProductCategoryMapper.updateByPrimaryKeySelective(pmsProductCategory);

	}

	@Override
	public void deletePmsProductCategory(long id){
		PmsProductCategoryMapper.deleteByPrimaryKey(id);

	}

}