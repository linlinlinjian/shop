package com.ssm.shop.pojo;

/**
 * 专题商品关系表
 * 
 * @author wcyong
 * 
 * @date 2019-05-21
 */
public class CmsSubjectProductRelation extends BaseModel{
    private Long id;

    private Long subjectId;

    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}