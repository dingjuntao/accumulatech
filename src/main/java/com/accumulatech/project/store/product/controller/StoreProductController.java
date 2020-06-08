package com.accumulatech.project.store.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.accumulatech.project.store.category.domain.StoreCategory;
import com.accumulatech.project.store.category.service.IStoreCategoryService;
import com.accumulatech.project.store.product.domain.StoreProductVo;
import com.accumulatech.project.system.attachment.domain.SysAttachment;
import com.accumulatech.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.accumulatech.framework.aspectj.lang.annotation.Log;
import com.accumulatech.framework.aspectj.lang.enums.BusinessType;
import com.accumulatech.project.store.product.domain.StoreProduct;
import com.accumulatech.project.store.product.service.IStoreProductService;
import com.accumulatech.framework.web.controller.BaseController;
import com.accumulatech.framework.web.domain.AjaxResult;
import com.accumulatech.common.utils.poi.ExcelUtil;
import com.accumulatech.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 商品Controller
 *
 * @author dingjt
 * @date 2020-06-06
 */
@Controller
@RequestMapping("/store/product")
public class StoreProductController extends BaseController {
    private String prefix = "store/product";

    @Autowired
    private IStoreProductService storeProductService;
    @Autowired
    private IStoreCategoryService storeCategoryService;

    @RequiresPermissions("store:product:view")
    @GetMapping()
    public String product() {
        return prefix + "/product";
    }

    /**
     * 查询商品列表
     */
    @RequiresPermissions("store:product:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StoreProduct storeProduct) {
        startPage();
        List<StoreProduct> list = storeProductService.selectStoreProductList(storeProduct);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @RequiresPermissions("store:product:export")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StoreProduct storeProduct) {
        List<StoreProduct> list = storeProductService.selectStoreProductList(storeProduct);
        ExcelUtil<StoreProduct> util = new ExcelUtil<StoreProduct>(StoreProduct.class);
        return util.exportExcel(list, "product");
    }

    /**
     * 新增商品
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存商品
     */
    @RequiresPermissions("store:product:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StoreProductVo storeProduct) {
        return toAjax(storeProductService.insertStoreProduct(storeProduct));
    }

    /**
     * 修改商品
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        StoreProductVo storeProduct = storeProductService.selectStoreProductById(id);
        StoreCategory storeCategory = storeCategoryService.selectStoreCategoryById(storeProduct.getCategoryId());
        mmap.put("storeProduct", storeProduct);
        mmap.put("description", storeProduct.getDescription());
        mmap.put("storeCategory", storeCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品
     */
    @RequiresPermissions("store:product:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StoreProductVo storeProduct) {
        return toAjax(storeProductService.updateStoreProduct(storeProduct));
    }

    /**
     * 删除商品
     */
    @RequiresPermissions("store:product:remove")
    @Log(title = "商品", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(storeProductService.deleteStoreProductByIds(ids));
    }

    /**
     * 商品上架状态修改
     */
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @RequiresPermissions("store:product:edit")
    @PostMapping("/changeIsShow")
    @ResponseBody
    public AjaxResult changeIsShow(StoreProduct entity) {
        return toAjax(storeProductService.changeIsShow(entity));
    }

    /**
     * 修改商品轮播图
     */
    @GetMapping("/slider/{id}")
    public String slider(@PathVariable("id") String id, ModelMap mmap, HttpServletRequest request) {
        StoreProductVo storeProduct = storeProductService.slider(id);
        StringBuffer location = new StringBuffer();
        location.append(request.getScheme())
                .append("://")
                .append(request.getServerName());
        if (storeProduct != null && storeProduct.getSliderImageList() != null) {
            List<String> sliderImageStr = storeProduct.getSliderImageList().stream()
                                            .map(s -> (location.toString() + s.getAttDir()))
                                            .collect(Collectors.toList());
            mmap.put("sliderImageStr", sliderImageStr);
        } else {
            mmap.put("sliderImageStr", "");
        }
        mmap.put("storeProduct", storeProduct);
        return prefix + "/slider";
    }

    /**
     * 修改保存商品轮播图
     */
    @RequiresPermissions("store:product:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/uploadSlider")
    @ResponseBody
    public AjaxResult uploadSlider(StoreProductVo storeProduct) {
        return toAjax(storeProductService.uploadSlider(storeProduct));
    }
}
