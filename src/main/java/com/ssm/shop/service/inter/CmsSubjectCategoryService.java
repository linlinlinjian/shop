package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.CmsSubjectCategory;

public interface CmsSubjectCategoryService {

	List<CmsSubjectCategory> listCmsSubjectCategory(CmsSubjectCategory cmsSubjectCategory);

	PageResult listCmsSubjectCategoryByPage(CmsSubjectCategory cmsSubjectCategory);

	int selectCount(CmsSubjectCategory cmsSubjectCategory);

	void saveCmsSubjectCategory(CmsSubjectCategory cmsSubjectCategory);

	void deleteCmsSubjectCategory(long id);

	void updateCmsSubjectCategory(CmsSubjectCategory cmsSubjectCategory);

	CmsSubjectCategory getCmsSubjectCategory(long id);

}