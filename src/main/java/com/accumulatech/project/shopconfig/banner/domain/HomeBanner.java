package com.accumulatech.project.shopconfig.banner.domain;

import com.accumulatech.framework.aspectj.lang.annotation.Excel;
import com.accumulatech.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 首页幻灯片对象 home_banner
 * 
 * @author dingjt
 * @date 2020-06-07
 */
public class HomeBanner extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    /** 标题 */
    private String title;
    /** H5跳转url */
    @Excel(name = "H5跳转url")
    private String urlStr;

    /** uniapp路由 */
    @Excel(name = "uniapp路由")
    private String uniappRouting;

    /** 附件id */
    @Excel(name = "附件id")
    private String attachmentId;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer sort;

    /** 是否显示（0显示，1隐藏） */
    @Excel(name = "是否显示", readConverterExp = "0=显示，1隐藏")
    private Integer isShow;

    /** 删除标注（0正常，1删除） */
    @Excel(name = "删除标注", readConverterExp = "0=正常，1删除")
    private Integer isDel;

    public void setUrlStr(String urlStr) 
    {
        this.urlStr = urlStr;
    }

    public String getUrlStr() 
    {
        return urlStr;
    }
    public void setUniappRouting(String uniappRouting) 
    {
        this.uniappRouting = uniappRouting;
    }

    public String getUniappRouting() 
    {
        return uniappRouting;
    }
    public void setAttachmentId(String attachmentId) 
    {
        this.attachmentId = attachmentId;
    }

    public String getAttachmentId() 
    {
        return attachmentId;
    }
    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() {
        return sort;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public void setIsDel(Integer isDel)
    {
        this.isDel = isDel;
    }

    public Integer getIsDel() 
    {
        return isDel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
