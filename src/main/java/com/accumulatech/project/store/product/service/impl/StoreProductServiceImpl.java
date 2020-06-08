package com.accumulatech.project.store.product.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.accumulatech.common.utils.DateUtils;
import com.accumulatech.common.utils.StringUtils;
import com.accumulatech.common.utils.file.FileUploadUtils;
import com.accumulatech.framework.config.AccumulatechConfig;
import com.accumulatech.project.store.product.domain.StoreProductVo;
import com.accumulatech.project.system.attachment.domain.SysAttachment;
import com.accumulatech.project.system.attachment.service.ISysAttachmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accumulatech.project.store.product.mapper.StoreProductMapper;
import com.accumulatech.project.store.product.domain.StoreProduct;
import com.accumulatech.project.store.product.service.IStoreProductService;
import com.accumulatech.common.utils.text.Convert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商品Service业务层处理
 * 
 * @author dingjt
 * @date 2020-06-06
 */
@Service
public class StoreProductServiceImpl implements IStoreProductService 
{
    @Autowired
    private StoreProductMapper storeProductMapper;
    @Autowired
    ISysAttachmentService attachmentService;

    /**
     * 查询商品
     */
    @Override
    public StoreProductVo selectStoreProductById(String id)
    {
        StoreProductVo vo = new StoreProductVo();
        StoreProduct storeProduct = storeProductMapper.selectStoreProductById(id);
        BeanUtils.copyProperties(storeProduct, vo);
        if(StringUtils.isNotBlank(storeProduct.getImg())){
            SysAttachment attachment = attachmentService.selectSysAttachmentById(storeProduct.getImg());
            Optional.ofNullable(attachment).ifPresent(a -> vo.setImgAtt(a));
        }
        return vo;
    }

    /**
     * 查询商品列表
     * 
     * @param storeProduct 商品
     * @return 商品
     */
    @Override
    public List<StoreProduct> selectStoreProductList(StoreProduct storeProduct)
    {
        return storeProductMapper.selectStoreProductList(storeProduct);
    }

    /**
     * 新增商品
     */
    @Override
    public int insertStoreProduct(StoreProductVo vo)
    {
        try {
            StoreProduct storeProduct = new StoreProduct();
            BeanUtils.copyProperties(vo, storeProduct);
            if(!vo.getImg().isEmpty()){
                //上传商品图片
                SysAttachment attachment = attachmentService.upload(vo.getImg());
                storeProduct.setImg(attachment.getId());
            }
            storeProduct.preInsert();
            return storeProductMapper.insertStoreProduct(storeProduct);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 修改商品
     */
    @Override
    public int updateStoreProduct(StoreProductVo vo)
    {
        try {
            StoreProduct storeProduct = new StoreProduct();
            BeanUtils.copyProperties(vo, storeProduct);
            if(!vo.getImg().isEmpty()){
                //上传新的商品图片，先删除旧的图片
                StoreProductVo old = selectStoreProductById(vo.getId());
                if(old.getImgAtt() != null){
                    attachmentService.deleteSysAttachmentById(old.getImgAtt().getId());
                }
                SysAttachment attachment = attachmentService.upload(vo.getImg());
                storeProduct.setImg(attachment.getId());
            }
            storeProduct.preUpdate();
            return storeProductMapper.updateStoreProduct(storeProduct);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 删除商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStoreProductByIds(String ids)
    {
        return storeProductMapper.deleteStoreProductByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品信息
     * 
     * @param id 商品ID
     * @return 结果
     */
    @Override
    public int deleteStoreProductById(String id)
    {
        return storeProductMapper.deleteStoreProductById(id);
    }

    @Override
    public int changeIsShow(StoreProduct entity) {
        return storeProductMapper.changeIsShow(entity.getId(), entity.getIsShow());
    }

    @Override
    public int uploadSlider(StoreProductVo vo) {
        try {
            StoreProduct storeProduct = new StoreProduct();
            BeanUtils.copyProperties(vo, storeProduct);
            if(!vo.getSliderImage().isEmpty()){
                //上传新的轮播图片，先删除旧的图片
                StoreProductVo old = slider(vo.getId());
                if(old.getSliderImageList() != null){
                    String[] ids = old.getSliderImageList().stream().map(SysAttachment::getId).toArray(String[]::new);
                    attachmentService.deleteSysAttachmentByIds(String.join(",", ids));
                }
                List<String> attIds = new ArrayList<>();
                for(MultipartFile file : vo.getSliderImage()){
                    SysAttachment attachment = attachmentService.upload(file);
                    attIds.add(attachment.getId());
                }
                storeProduct.setSliderImage(String.join(",", attIds));
            }
            storeProduct.preUpdate();
            return storeProductMapper.updateStoreProduct(storeProduct);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public StoreProductVo slider(String id) {
        StoreProductVo vo = new StoreProductVo();
        StoreProduct storeProduct = storeProductMapper.selectStoreProductById(id);
        BeanUtils.copyProperties(storeProduct, vo);
        if(StringUtils.isNotBlank(storeProduct.getSliderImage())){
            List<SysAttachment> attList = attachmentService.selectSysAttachmentByIds(Convert.toStrArray(storeProduct.getSliderImage()));
            vo.setSliderImageList(attList);
        }
        return vo;
    }
}
