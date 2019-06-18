package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.CmsSubjectComment;

public interface CmsSubjectCommentService {

	List<CmsSubjectComment> listCmsSubjectComment(CmsSubjectComment cmsSubjectComment);

	PageResult listCmsSubjectCommentByPage(CmsSubjectComment cmsSubjectComment);

	int selectCount(CmsSubjectComment cmsSubjectComment);

	void saveCmsSubjectComment(CmsSubjectComment cmsSubjectComment);

	void deleteCmsSubjectComment(long id);

	void updateCmsSubjectComment(CmsSubjectComment cmsSubjectComment);

	CmsSubjectComment getCmsSubjectComment(long id);

}