package com.accumulatech.project.store.product.service;

import java.util.List;
import com.accumulatech.project.store.product.domain.StoreProduct;
import com.accumulatech.project.store.product.domain.StoreProductVo;

/**
 * 商品Service接口
 * 
 * @author dingjt
 * @date 2020-06-06
 */
public interface IStoreProductService 
{
    /**
     * 查询商品
     * 
     * @param id 商品ID
     * @return 商品
     */
    public StoreProductVo selectStoreProductById(String id);

    /**
     * 查询商品列表
     * 
     * @param storeProduct 商品
     * @return 商品集合
     */
    public List<StoreProduct> selectStoreProductList(StoreProduct storeProduct);

    /**
     * 新增商品
     * 
     * @param storeProduct 商品
     * @return 结果
     */
    public int insertStoreProduct(StoreProductVo storeProduct);

    /**
     * 修改商品
     * 
     * @param storeProduct 商品
     * @return 结果
     */
    public int updateStoreProduct(StoreProductVo storeProduct);

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStoreProductByIds(String ids);

    /**
     * 删除商品信息
     * 
     * @param id 商品ID
     * @return 结果
     */
    public int deleteStoreProductById(String id);

    int changeIsShow(StoreProduct entity);

    int uploadSlider(StoreProductVo storeProduct);

    StoreProductVo slider(String id);
}
