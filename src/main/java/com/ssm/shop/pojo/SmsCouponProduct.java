package com.ssm.shop.pojo;

/**
 * 优惠券和产品的关系表
 * 
 * @author wcyong
 * 
 * @date 2019-06-16
 */
public class SmsCouponProduct {
    private Long id;

    private Long couponId;

    private Long productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品编码
     */
    private String productSn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn == null ? null : productSn.trim();
    }
}