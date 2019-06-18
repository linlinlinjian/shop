package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.CmsSubject;

public interface CmsSubjectService {

	List<CmsSubject> listCmsSubject(CmsSubject cmsSubject);

	PageResult listCmsSubjectByPage(CmsSubject cmsSubject);

	int selectCount(CmsSubject cmsSubject);

	void saveCmsSubject(CmsSubject cmsSubject);

	void deleteCmsSubject(long id);

	void updateCmsSubject(CmsSubject cmsSubject);

	CmsSubject getCmsSubject(long id);

}