package com.accumulatech.project.store.product.domain;

import com.accumulatech.framework.aspectj.lang.annotation.Excel;
import com.accumulatech.framework.web.domain.BaseEntity;
import com.accumulatech.project.system.attachment.domain.SysAttachment;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * 商品对象 store_product
 *
 * @author dingjt
 * @date 2020-06-06
 */
@Data
public class StoreProductVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private String id;

    /** 商户Id(0为总后台管理员创建,不为0的时候是商户后台创建) */
    private Integer merId;

    /** 商品图片 */
    private MultipartFile img;

    /** 商品图片附件 */
    private SysAttachment imgAtt;

    /** 轮播图 */
    private List<MultipartFile> sliderImage;
    /** 轮播图附件 */
    private List<SysAttachment> sliderImageList;

    /** 商品名称 */
    private String storeName;

    /** 商品简介 */
    private String storeInfo;

    /** 关键字 */
    private String keyword;

    /** 产品条码（一维码） */
    private String barCode;

    /** 分类id */
    private String categoryId;

    /** 商品价格 */
    private Double price;

    /** 会员价格 */
    private Double vipPrice;

    /** 市场价 */
    private Double otPrice;

    /** 邮费 */
    private Double postage;

    /** 排序 */
    private Long sort;

    /** 销量 */
    private Long sales;

    /** 库存 */
    private Long stock;

    /** 状态（0：未上架，1：上架） */
    private Integer isShow;

    /** 是否热卖（0是，1否） */
    private Integer isHot;

    /** 是否优惠（0是，1否） */
    private Integer isBenefit;

    /** 是否精品（0是，1否） */
    private Integer isBest;

    /** 是否新品（0是，1否） */
    private Integer isNew;

    /** 产品描述 */
    private String description;

    /** 是否包邮（0是，1否） */
    private Integer isPostage;

    /** 是否删除（0正常，1删除） */
    private Integer isDel;

    /** 获得积分 */
    private Double giveIntegral;

    /** 成本价 */
    private Double cost;

    /** 浏览量 */
    private Long browse;

    /** 产品二维码地址(用户小程序海报) */
    private String codePath;

}