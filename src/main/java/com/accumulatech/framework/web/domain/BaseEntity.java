package com.accumulatech.framework.web.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Maps;
import com.accumulatech.common.utils.DateUtils;
import com.accumulatech.common.utils.IdGen;
import com.accumulatech.common.utils.security.ShiroUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Entity基类
 * 
 * @author ruoyi
 */
@Data
public class BaseEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String id;
    /** 搜索值 */
    private String searchValue;

    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 备注 */
    private String remark;

    /** 请求参数 */
    private Map<String, Object> params;

    public Map<String, Object> getParams()
    {
        if (params == null)
        {
            params = Maps.newHashMap();
        }
        return params;
    }

    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert(){
        setId(IdGen.uuid());
        if (StringUtils.isNotBlank(ShiroUtils.getLoginName())){
            this.updateBy =ShiroUtils.getLoginName();
            this.createBy =ShiroUtils.getLoginName();
        }
        this.updateTime = DateUtils.getNowDate();
        this.createTime = this.updateTime;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate(){
        if (StringUtils.isNotBlank(ShiroUtils.getLoginName())){
            this.updateBy = ShiroUtils.getLoginName();
        }
        this.updateTime = DateUtils.getNowDate();
    }
}
