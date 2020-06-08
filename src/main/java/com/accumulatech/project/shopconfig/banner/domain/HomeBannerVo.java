package com.accumulatech.project.shopconfig.banner.domain;

import com.accumulatech.framework.aspectj.lang.annotation.Excel;
import com.accumulatech.framework.web.domain.BaseEntity;
import com.accumulatech.project.system.attachment.domain.SysAttachment;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.multipart.MultipartFile;

/**
 * 首页幻灯片对象 home_banner
 * 
 * @author dingjt
 * @date 2020-06-07
 */
public class HomeBannerVo extends BaseEntity
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

    /** 附件 */
    private MultipartFile attachmentFile;

    /** 附件 */
    private SysAttachment attachment;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer sort;

    /** 是否显示（0显示，1隐藏） */
    @Excel(name = "是否显示", readConverterExp = "0=显示，1隐藏")
    private Integer isshow;

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

    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
    }
    public void setIsshow(Integer isshow) 
    {
        this.isshow = isshow;
    }

    public Integer getIsshow() 
    {
        return isshow;
    }
    public void setIsDel(Integer isDel) 
    {
        this.isDel = isDel;
    }

    public Integer getIsDel() 
    {
        return isDel;
    }

    public MultipartFile getAttachmentFile() {
        return attachmentFile;
    }

    public void setAttachmentFile(MultipartFile attachmentFile) {
        this.attachmentFile = attachmentFile;
    }

    public SysAttachment getAttachment() {
        return attachment;
    }

    public void setAttachment(SysAttachment attachment) {
        this.attachment = attachment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("urlStr", getUrlStr())
            .append("uniappRouting", getUniappRouting())
            .append("sort", getSort())
            .append("isshow", getIsshow())
            .append("isDel", getIsDel())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
