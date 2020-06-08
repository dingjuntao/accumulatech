package com.accumulatech.project.system.attachment.service;

import com.accumulatech.project.system.attachment.domain.SysAttachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 附件Service接口
 * 
 * @author dingjt
 * @date 2020-06-07
 */
public interface ISysAttachmentService 
{

    /**
     * 上传图片
     */
    public SysAttachment upload(MultipartFile file) throws IOException;
    /**
     * 查询附件
     * 
     * @param id 附件ID
     * @return 附件
     */
    public SysAttachment selectSysAttachmentById(String id);

    /**
     * 查询附件
     */
    public List<SysAttachment> selectSysAttachmentByIds(String[] ids);

    /**
     * 查询附件列表
     * 
     * @param sysAttachment 附件
     * @return 附件集合
     */
    public List<SysAttachment> selectSysAttachmentList(SysAttachment sysAttachment);

    /**
     * 新增附件
     * 
     * @param sysAttachment 附件
     * @return 结果
     */
    public int insertSysAttachment(SysAttachment sysAttachment);

    /**
     * 修改附件
     * 
     * @param sysAttachment 附件
     * @return 结果
     */
    public int updateSysAttachment(SysAttachment sysAttachment);

    /**
     * 批量删除附件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysAttachmentByIds(String ids);

    /**
     * 删除附件信息
     * 
     * @param id 附件ID
     * @return 结果
     */
    public int deleteSysAttachmentById(String id);
}
