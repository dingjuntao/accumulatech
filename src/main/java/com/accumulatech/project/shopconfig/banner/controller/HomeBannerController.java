package com.accumulatech.project.shopconfig.banner.controller;

import java.util.List;

import com.accumulatech.project.shopconfig.banner.domain.HomeBanner;
import com.accumulatech.project.shopconfig.banner.domain.HomeBannerVo;
import com.accumulatech.project.shopconfig.banner.service.IHomeBannerService;
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
import com.accumulatech.framework.web.controller.BaseController;
import com.accumulatech.framework.web.domain.AjaxResult;
import com.accumulatech.common.utils.poi.ExcelUtil;
import com.accumulatech.framework.web.page.TableDataInfo;

/**
 * 首页幻灯片Controller
 * 
 * @author dingjt
 * @date 2020-06-07
 */
@Controller
@RequestMapping("/shopconfig/banner")
public class HomeBannerController extends BaseController
{
    private String prefix = "shopconfig/banner";

    @Autowired
    private IHomeBannerService homeBannerService;

    @RequiresPermissions("shopconfig:banner:view")
    @GetMapping()
    public String banner()
    {
        return prefix + "/banner";
    }

    /**
     * 查询首页幻灯片列表
     */
    @RequiresPermissions("shopconfig:banner:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HomeBanner homeBanner)
    {
        startPage();
        List<HomeBanner> list = homeBannerService.selectHomeBannerList(homeBanner);
        return getDataTable(list);
    }

    /**
     * 导出首页幻灯片列表
     */
    @RequiresPermissions("shopconfig:banner:export")
    @Log(title = "首页幻灯片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HomeBanner homeBanner)
    {
        List<HomeBanner> list = homeBannerService.selectHomeBannerList(homeBanner);
        ExcelUtil<HomeBanner> util = new ExcelUtil<HomeBanner>(HomeBanner.class);
        return util.exportExcel(list, "banner");
    }

    /**
     * 新增首页幻灯片
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存首页幻灯片
     */
    @RequiresPermissions("shopconfig:banner:add")
    @Log(title = "首页幻灯片", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HomeBannerVo homeBanner)
    {
        return toAjax(homeBannerService.insertHomeBanner(homeBanner));
    }

    /**
     * 修改首页幻灯片
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        HomeBannerVo homeBanner = homeBannerService.selectHomeBannerById(id);
        mmap.put("homeBanner", homeBanner);
        return prefix + "/edit";
    }

    /**
     * 修改保存首页幻灯片
     */
    @RequiresPermissions("shopconfig:banner:edit")
    @Log(title = "首页幻灯片", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HomeBannerVo homeBanner)
    {
        return toAjax(homeBannerService.updateHomeBanner(homeBanner));
    }

    /**
     * 删除首页幻灯片
     */
    @RequiresPermissions("shopconfig:banner:remove")
    @Log(title = "首页幻灯片", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(homeBannerService.deleteHomeBannerByIds(ids));
    }
}
