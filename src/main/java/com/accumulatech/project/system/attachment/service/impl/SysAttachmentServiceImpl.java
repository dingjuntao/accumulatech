package com.accumulatech.project.system.attachment.service.impl;

import java.io.IOException;
import java.util.List;
import com.accumulatech.common.utils.DateUtils;
import com.accumulatech.common.utils.file.FileUploadUtils;
import com.accumulatech.framework.config.AccumulatechConfig;
import com.accumulatech.project.system.attachment.domain.SysAttachment;
import com.accumulatech.project.system.attachment.mapper.SysAttachmentMapper;
import com.accumulatech.project.system.attachment.service.ISysAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accumulatech.common.utils.text.Convert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 附件Service业务层处理
 * 
 * @author dingjt
 * @date 2020-06-07
 */
@Service
public class SysAttachmentServiceImpl implements ISysAttachmentService
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Override
    public SysAttachment upload(MultipartFile file) throws IOException {
        SysAttachment attachment = new SysAttachment();
        //上传商品图片
        String path = FileUploadUtils.upload(AccumulatechConfig.getAvatarPath(), file);
        attachment.setAttType(FileUploadUtils.getExtension(file));
        attachment.setAttDir(path);
        attachment.setAttSize(String.valueOf(file.getSize()));
        attachment.setName(FileUploadUtils.getName(path));
        insertSysAttachment(attachment);
        return attachment;
    }

    /**
     * 查询附件
     * 
     * @param id 附件ID
     * @return 附件
     */
    @Override
    public SysAttachment selectSysAttachmentById(String id)
    {
        return sysAttachmentMapper.selectSysAttachmentById(id);
    }

    @Override
    public List<SysAttachment> selectSysAttachmentByIds(String[] ids) {
        return sysAttachmentMapper.selectSysAttachmentByIds(ids);
    }

    /**
     * 查询附件列表
     * 
     * @param sysAttachment 附件
     * @return 附件
     */
    @Override
    public List<SysAttachment> selectSysAttachmentList(SysAttachment sysAttachment)
    {
        return sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
    }

    /**
     * 新增附件
     * 
     * @param sysAttachment 附件
     * @return 结果
     */
    @Override
    public int insertSysAttachment(SysAttachment sysAttachment)
    {
        sysAttachment.preInsert();
        return sysAttachmentMapper.insertSysAttachment(sysAttachment);
    }

    /**
     * 修改附件
     * 
     * @param sysAttachment 附件
     * @return 结果
     */
    @Override
    public int updateSysAttachment(SysAttachment sysAttachment)
    {
        sysAttachment.preUpdate();
        return sysAttachmentMapper.updateSysAttachment(sysAttachment);
    }

    /**
     * 删除附件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysAttachmentByIds(String ids)
    {
        return sysAttachmentMapper.deleteSysAttachmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除附件信息
     * 
     * @param id 附件ID
     * @return 结果
     */
    @Override
    public int deleteSysAttachmentById(String id)
    {
        SysAttachment attachment = selectSysAttachmentById(id);
        //删除图片
        FileUploadUtils.delete(attachment.getAttDir());
        return sysAttachmentMapper.deleteSysAttachmentById(id);
    }
}
