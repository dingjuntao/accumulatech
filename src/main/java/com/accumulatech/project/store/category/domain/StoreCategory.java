package com.accumulatech.project.store.category.domain;

import com.accumulatech.framework.aspectj.lang.annotation.Excel;
import com.accumulatech.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * 商品分类对象 store_category
 * 
 * @author dingjt
 * @date 2020-06-06
 */
@Data
public class StoreCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 父节点ID */
    @Excel(name = "父节点ID")
    private String parentId;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String classifyName;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer sort;

    /** 是否显示（0显示，1隐藏） */
    @Excel(name = "是否显示", readConverterExp = "0=显示，1隐藏")
    private Integer visible;

    /** 删除标注（0正常，1删除） */
    @Excel(name = "删除标注", readConverterExp = "0=正常，1删除")
    private Integer isDel;


}
