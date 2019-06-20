package com.ssm.shop.pojo;

import lombok.Data;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-06-19
 */
@Data
public class PmsBanner extends BaseModel {
    private Long id;

    private String title;

    private String content;

    private String imgUrl;

    private String sort;

    //private String createTime;

    /**
     * 0分类1商品2活动
     */
    private String types;

    /**
     * 关联id
     */
    private Long relationId;

    /**
     * 0跳转1无需跳转
     */
    private String isRedirect;
}