package com.accumulatech.project.shopconfig.banner.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.accumulatech.common.utils.DateUtils;
import com.accumulatech.common.utils.StringUtils;
import com.accumulatech.project.shopconfig.banner.domain.HomeBanner;
import com.accumulatech.project.shopconfig.banner.domain.HomeBannerVo;
import com.accumulatech.project.shopconfig.banner.mapper.HomeBannerMapper;
import com.accumulatech.project.shopconfig.banner.service.IHomeBannerService;
import com.accumulatech.project.store.product.domain.StoreProduct;
import com.accumulatech.project.store.product.domain.StoreProductVo;
import com.accumulatech.project.system.attachment.domain.SysAttachment;
import com.accumulatech.project.system.attachment.service.ISysAttachmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accumulatech.common.utils.text.Convert;

/**
 * 首页幻灯片Service业务层处理
 * 
 * @author dingjt
 * @date 2020-06-07
 */
@Service
public class HomeBannerServiceImpl implements IHomeBannerService
{
    @Autowired
    private HomeBannerMapper homeBannerMapper;
    @Autowired
    ISysAttachmentService attachmentService;

    /**
     * 查询首页幻灯片
     * 
     * @param id 首页幻灯片ID
     * @return 首页幻灯片
     */
    @Override
    public HomeBannerVo selectHomeBannerById(String id)
    {
        HomeBannerVo vo = new HomeBannerVo();
        HomeBanner homeBanner = homeBannerMapper.selectHomeBannerById(id);
        BeanUtils.copyProperties(homeBanner, vo);
        if(StringUtils.isNotBlank(homeBanner.getAttachmentId())){
            SysAttachment attachment = attachmentService.selectSysAttachmentById(homeBanner.getAttachmentId());
            Optional.ofNullable(attachment).ifPresent(a -> vo.setAttachment(a));
        }
        return vo;
    }

    /**
     * 查询首页幻灯片列表
     * 
     * @param homeBanner 首页幻灯片
     * @return 首页幻灯片
     */
    @Override
    public List<HomeBanner> selectHomeBannerList(HomeBanner homeBanner)
    {
        return homeBannerMapper.selectHomeBannerList(homeBanner);
    }

    /**
     * 新增首页幻灯片
     * @return 结果
     */
    @Override
    public int insertHomeBanner(HomeBannerVo vo)
    {
        try {
            HomeBanner homeBanner = new HomeBanner();
            BeanUtils.copyProperties(vo, homeBanner);
            if(!vo.getAttachmentFile().isEmpty()){
                //上传商品图片
                SysAttachment attachment = attachmentService.upload(vo.getAttachmentFile());
                homeBanner.setAttachmentId(attachment.getId());
            }
            homeBanner.preInsert();
            return homeBannerMapper.insertHomeBanner(homeBanner);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 修改首页幻灯片
     */
    @Override
    public int updateHomeBanner(HomeBannerVo vo)
    {
        try {
            HomeBanner homeBanner = new HomeBanner();
            BeanUtils.copyProperties(vo, homeBanner);
            if(!vo.getAttachmentFile().isEmpty()){
                //上传新的商品图片，先删除旧的图片
                HomeBannerVo old = selectHomeBannerById(vo.getId());
                if(old.getAttachment() != null){
                    attachmentService.deleteSysAttachmentById(old.getAttachment().getId());
                }
                SysAttachment attachment = attachmentService.upload(vo.getAttachmentFile());
                homeBanner.setAttachmentId(attachment.getId());
            }
            homeBanner.preUpdate();
            return homeBannerMapper.updateHomeBanner(homeBanner);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 删除首页幻灯片对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHomeBannerByIds(String ids)
    {
        return homeBannerMapper.deleteHomeBannerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除首页幻灯片信息
     * 
     * @param id 首页幻灯片ID
     * @return 结果
     */
    @Override
    public int deleteHomeBannerById(String id)
    {
        return homeBannerMapper.deleteHomeBannerById(id);
    }
}
