package com.accumulatech.project.system.attachment.domain;

import com.accumulatech.framework.aspectj.lang.annotation.Excel;
import com.accumulatech.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * 附件对象 sys_attachment
 * 
 * @author dingjt
 * @date 2020-06-07
 */
public class SysAttachment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 附件名称 */
    @Excel(name = "附件名称")
    private String name;

    /** 附件路径 */
    @Excel(name = "附件路径")
    private String attDir;

    /** 压缩图片路径 */
    @Excel(name = "压缩图片路径")
    private String sattDir;

    /** 附件大小 */
    @Excel(name = "附件大小")
    private String attSize;

    /** 附件类型 */
    @Excel(name = "附件类型")
    private String attType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttDir() {
        return attDir;
    }

    public void setAttDir(String attDir) {
        this.attDir = attDir;
    }

    public String getSattDir() {
        return sattDir;
    }

    public void setSattDir(String sattDir) {
        this.sattDir = sattDir;
    }

    public String getAttSize() {
        return attSize;
    }

    public void setAttSize(String attSize) {
        this.attSize = attSize;
    }

    public String getAttType() {
        return attType;
    }

    public void setAttType(String attType) {
        this.attType = attType;
    }
}
