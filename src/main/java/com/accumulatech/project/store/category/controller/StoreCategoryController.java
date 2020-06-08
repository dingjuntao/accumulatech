package com.accumulatech.project.store.category.controller;

import java.util.List;

import com.accumulatech.common.constant.Constants;
import com.accumulatech.framework.web.domain.ZtreeTwo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.accumulatech.framework.aspectj.lang.annotation.Log;
import com.accumulatech.framework.aspectj.lang.enums.BusinessType;
import com.accumulatech.project.store.category.domain.StoreCategory;
import com.accumulatech.project.store.category.service.IStoreCategoryService;
import com.accumulatech.framework.web.controller.BaseController;
import com.accumulatech.framework.web.domain.AjaxResult;
import com.accumulatech.common.utils.poi.ExcelUtil;

/**
 * 商品分类Controller
 * 
 * @author dingjt
 * @date 2020-06-06
 */
@Controller
@RequestMapping("/store/category")
public class StoreCategoryController extends BaseController
{
    private String prefix = "store/category";

    @Autowired
    private IStoreCategoryService storeCategoryService;

    @RequiresPermissions("store:category:view")
    @GetMapping()
    public String category()
    {
        return prefix + "/category";
    }

    /**
     * 查询商品分类列表
     */
    @RequiresPermissions("store:category:list")
    @PostMapping("/list")
    @ResponseBody
    public List<StoreCategory> list(StoreCategory storeCategory)
    {
        List<StoreCategory> list = storeCategoryService.selectStoreCategoryList(storeCategory);
        return list;
    }

    /**
     * 导出商品分类列表
     */
    @RequiresPermissions("store:category:export")
    @Log(title = "商品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StoreCategory storeCategory)
    {
        List<StoreCategory> list = storeCategoryService.selectStoreCategoryList(storeCategory);
        ExcelUtil<StoreCategory> util = new ExcelUtil<StoreCategory>(StoreCategory.class);
        return util.exportExcel(list, "category");
    }

    /**
     * 新增商品分类
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") String parentId, ModelMap mmap)
    {
        StoreCategory storeCategory = null;
        if (!parentId.equals(Constants.ZERO))
        {
            storeCategory = storeCategoryService.selectStoreCategoryById(parentId);
        }
        else
        {
            storeCategory = new StoreCategory();
            storeCategory.setId(Constants.ZERO);
            storeCategory.setClassifyName("主菜单");
        }
        mmap.put("category", storeCategory);
        return prefix + "/add";
    }

    /**
     * 新增保存商品分类
     */
    @RequiresPermissions("store:category:add")
    @Log(title = "商品分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StoreCategory storeCategory)
    {
        return toAjax(storeCategoryService.insertStoreCategory(storeCategory));
    }

    /**
     * 修改商品分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        StoreCategory storeCategory = storeCategoryService.selectStoreCategoryById(id);
        mmap.put("storeCategory", storeCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品分类
     */
    @RequiresPermissions("store:category:edit")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StoreCategory storeCategory)
    {
        return toAjax(storeCategoryService.updateStoreCategory(storeCategory));
    }

    /**
     * 删除商品分类
     */
    @RequiresPermissions("store:category:remove")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
    @GetMapping( "/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") String id)
    {
        return toAjax(storeCategoryService.deleteStoreCategoryById(id));
    }

    /**
     * 选择部门树
     */
    @GetMapping("/selectCategoryTree/{id}")
    public String selectCategoryTree(@PathVariable("id") String id, ModelMap mmap)
    {
        StoreCategory storeCategory = null;
        if (!id.equals(Constants.ZERO))
        {
            storeCategory = storeCategoryService.selectStoreCategoryById(id);
        }
        else
        {
            storeCategory = new StoreCategory();
            storeCategory.setId(Constants.ZERO);
            storeCategory.setClassifyName("主菜单");
        }
        mmap.put("category", storeCategory);
        return prefix + "/tree";
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<ZtreeTwo> treeData()
    {
        List<ZtreeTwo> ztrees = storeCategoryService.selectCategoryTree(new StoreCategory());
        return ztrees;
    }
}
