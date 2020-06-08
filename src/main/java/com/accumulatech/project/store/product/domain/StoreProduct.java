package com.accumulatech.project.store.product.domain;

import com.accumulatech.framework.aspectj.lang.annotation.Excel;
import com.accumulatech.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品对象 store_product
 *
 * @author dingjt
 * @date 2020-06-06
 */
public class StoreProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private String id;

    /** 商户Id(0为总后台管理员创建,不为0的时候是商户后台创建) */
    @Excel(name = "商户Id(0为总后台管理员创建,不为0的时候是商户后台创建)")
    private Integer merId;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String img;

    /** 轮播图 */
    @Excel(name = "轮播图")
    private String sliderImage;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String storeName;

    /** 商品简介 */
    @Excel(name = "商品简介")
    private String storeInfo;

    /** 关键字 */
    @Excel(name = "关键字")
    private String keyword;

    /** 产品条码（一维码） */
    @Excel(name = "产品条码", readConverterExp = "一=维码")
    private String barCode;

    /** 分类id */
    @Excel(name = "分类id")
    private String categoryId;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private Double price;

    /** 会员价格 */
    @Excel(name = "会员价格")
    private Double vipPrice;

    /** 市场价 */
    @Excel(name = "市场价")
    private Double otPrice;

    /** 邮费 */
    @Excel(name = "邮费")
    private Double postage;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 销量 */
    @Excel(name = "销量")
    private Long sales;

    /** 库存 */
    @Excel(name = "库存")
    private Long stock;

    /** 状态（0：未上架，1：上架） */
    @Excel(name = "状态", readConverterExp = "0=：未上架，1：上架")
    private Integer isShow;

    /** 是否热卖（0是，1否） */
    @Excel(name = "是否热卖", readConverterExp = "0=是，1否")
    private Integer isHot;

    /** 是否优惠（0是，1否） */
    @Excel(name = "是否优惠", readConverterExp = "0=是，1否")
    private Integer isBenefit;

    /** 是否精品（0是，1否） */
    @Excel(name = "是否精品", readConverterExp = "0=是，1否")
    private Integer isBest;

    /** 是否新品（0是，1否） */
    @Excel(name = "是否新品", readConverterExp = "0=是，1否")
    private Integer isNew;

    /** 产品描述 */
    @Excel(name = "产品描述")
    private String description;

    /** 是否包邮（0是，1否） */
    @Excel(name = "是否包邮", readConverterExp = "0=是，1否")
    private Integer isPostage;

    /** 是否删除（0正常，1删除） */
    @Excel(name = "是否删除", readConverterExp = "0=正常，1删除")
    private Integer isDel;

    /** 获得积分 */
    @Excel(name = "获得积分")
    private Double giveIntegral;

    /** 成本价 */
    @Excel(name = "成本价")
    private Double cost;

    /** 浏览量 */
    @Excel(name = "浏览量")
    private Long browse;

    /** 产品二维码地址(用户小程序海报) */
    @Excel(name = "产品二维码地址(用户小程序海报)")
    private String codePath;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setMerId(Integer merId)
    {
        this.merId = merId;
    }

    public Integer getMerId()
    {
        return merId;
    }
    public void setImg(String img)
    {
        this.img = img;
    }

    public String getImg()
    {
        return img;
    }
    public void setSliderImage(String sliderImage)
    {
        this.sliderImage = sliderImage;
    }

    public String getSliderImage()
    {
        return sliderImage;
    }
    public void setStoreName(String storeName)
    {
        this.storeName = storeName;
    }

    public String getStoreName()
    {
        return storeName;
    }
    public void setStoreInfo(String storeInfo)
    {
        this.storeInfo = storeInfo;
    }

    public String getStoreInfo()
    {
        return storeInfo;
    }
    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    public String getKeyword()
    {
        return keyword;
    }
    public void setBarCode(String barCode)
    {
        this.barCode = barCode;
    }

    public String getBarCode()
    {
        return barCode;
    }
    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getCategoryId()
    {
        return categoryId;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }
    public void setVipPrice(Double vipPrice)
    {
        this.vipPrice = vipPrice;
    }

    public Double getVipPrice()
    {
        return vipPrice;
    }
    public void setOtPrice(Double otPrice)
    {
        this.otPrice = otPrice;
    }

    public Double getOtPrice()
    {
        return otPrice;
    }
    public void setPostage(Double postage)
    {
        this.postage = postage;
    }

    public Double getPostage()
    {
        return postage;
    }
    public void setSort(Long sort)
    {
        this.sort = sort;
    }

    public Long getSort()
    {
        return sort;
    }
    public void setSales(Long sales)
    {
        this.sales = sales;
    }

    public Long getSales()
    {
        return sales;
    }
    public void setStock(Long stock)
    {
        this.stock = stock;
    }

    public Long getStock()
    {
        return stock;
    }
    public void setIsShow(Integer isShow)
    {
        this.isShow = isShow;
    }

    public Integer getIsShow()
    {
        return isShow;
    }
    public void setIsHot(Integer isHot)
    {
        this.isHot = isHot;
    }

    public Integer getIsHot()
    {
        return isHot;
    }
    public void setIsBenefit(Integer isBenefit)
    {
        this.isBenefit = isBenefit;
    }

    public Integer getIsBenefit()
    {
        return isBenefit;
    }
    public void setIsBest(Integer isBest)
    {
        this.isBest = isBest;
    }

    public Integer getIsBest()
    {
        return isBest;
    }
    public void setIsNew(Integer isNew)
    {
        this.isNew = isNew;
    }

    public Integer getIsNew()
    {
        return isNew;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setIsPostage(Integer isPostage)
    {
        this.isPostage = isPostage;
    }

    public Integer getIsPostage()
    {
        return isPostage;
    }
    public void setIsDel(Integer isDel)
    {
        this.isDel = isDel;
    }

    public Integer getIsDel()
    {
        return isDel;
    }
    public void setGiveIntegral(Double giveIntegral)
    {
        this.giveIntegral = giveIntegral;
    }

    public Double getGiveIntegral()
    {
        return giveIntegral;
    }
    public void setCost(Double cost)
    {
        this.cost = cost;
    }

    public Double getCost()
    {
        return cost;
    }
    public void setBrowse(Long browse)
    {
        this.browse = browse;
    }

    public Long getBrowse()
    {
        return browse;
    }
    public void setCodePath(String codePath)
    {
        this.codePath = codePath;
    }

    public String getCodePath()
    {
        return codePath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("merId", getMerId())
                .append("img", getImg())
                .append("sliderImage", getSliderImage())
                .append("storeName", getStoreName())
                .append("storeInfo", getStoreInfo())
                .append("keyword", getKeyword())
                .append("barCode", getBarCode())
                .append("categoryId", getCategoryId())
                .append("price", getPrice())
                .append("vipPrice", getVipPrice())
                .append("otPrice", getOtPrice())
                .append("postage", getPostage())
                .append("sort", getSort())
                .append("sales", getSales())
                .append("stock", getStock())
                .append("isShow", getIsShow())
                .append("isHot", getIsHot())
                .append("isBenefit", getIsBenefit())
                .append("isBest", getIsBest())
                .append("isNew", getIsNew())
                .append("description", getDescription())
                .append("isPostage", getIsPostage())
                .append("isDel", getIsDel())
                .append("giveIntegral", getGiveIntegral())
                .append("cost", getCost())
                .append("browse", getBrowse())
                .append("codePath", getCodePath())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}