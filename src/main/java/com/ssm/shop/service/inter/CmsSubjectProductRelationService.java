package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.CmsSubjectProductRelation;

public interface CmsSubjectProductRelationService {

	List<CmsSubjectProductRelation> listCmsSubjectProductRelation(CmsSubjectProductRelation cmsSubjectProductRelation);

	PageResult listCmsSubjectProductRelationByPage(CmsSubjectProductRelation cmsSubjectProductRelation);

	int selectCount(CmsSubjectProductRelation cmsSubjectProductRelation);

	void saveCmsSubjectProductRelation(CmsSubjectProductRelation cmsSubjectProductRelation);

	void deleteCmsSubjectProductRelation(long id);

	void updateCmsSubjectProductRelation(CmsSubjectProductRelation cmsSubjectProductRelation);

	CmsSubjectProductRelation getCmsSubjectProductRelation(long id);

}