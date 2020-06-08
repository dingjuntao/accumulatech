package com.accumulatech.project.system.attachment.controller;

import java.util.List;

import com.accumulatech.project.system.attachment.domain.SysAttachment;
import com.accumulatech.project.system.attachment.service.ISysAttachmentService;
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
 * 附件Controller
 *
 * @author dingjt
 * @date 2020-06-07
 */
@Controller
@RequestMapping("/store/attachment")
public class SysAttachmentController extends BaseController
{
    private String prefix = "store/attachment";

    @Autowired
    private ISysAttachmentService sysAttachmentService;

    @RequiresPermissions("store:attachment:view")
    @GetMapping()
    public String attachment()
    {
        return prefix + "/attachment";
    }

    /**
     * 查询附件列表
     */
    @RequiresPermissions("store:attachment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysAttachment sysAttachment)
    {
        startPage();
        List<SysAttachment> list = sysAttachmentService.selectSysAttachmentList(sysAttachment);
        return getDataTable(list);
    }

    /**
     * 导出附件列表
     */
    @RequiresPermissions("store:attachment:export")
    @Log(title = "附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysAttachment sysAttachment)
    {
        List<SysAttachment> list = sysAttachmentService.selectSysAttachmentList(sysAttachment);
        ExcelUtil<SysAttachment> util = new ExcelUtil<SysAttachment>(SysAttachment.class);
        return util.exportExcel(list, "attachment");
    }

    /**
     * 新增附件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存附件
     */
    @RequiresPermissions("store:attachment:add")
    @Log(title = "附件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysAttachment sysAttachment)
    {
        return toAjax(sysAttachmentService.insertSysAttachment(sysAttachment));
    }

    /**
     * 修改附件
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        SysAttachment sysAttachment = sysAttachmentService.selectSysAttachmentById(id);
        mmap.put("sysAttachment", sysAttachment);
        return prefix + "/edit";
    }

    /**
     * 修改保存附件
     */
    @RequiresPermissions("store:attachment:edit")
    @Log(title = "附件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysAttachment sysAttachment)
    {
        return toAjax(sysAttachmentService.updateSysAttachment(sysAttachment));
    }

    /**
     * 删除附件
     */
    @RequiresPermissions("store:attachment:remove")
    @Log(title = "附件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysAttachmentService.deleteSysAttachmentByIds(ids));
    }
}
