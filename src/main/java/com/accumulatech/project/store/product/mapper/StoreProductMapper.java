package com.accumulatech.project.store.product.mapper;

import java.util.List;
import com.accumulatech.project.store.product.domain.StoreProduct;
import org.apache.ibatis.annotations.Param;

/**
 * 商品Mapper接口
 * 
 * @author dingjt
 * @date 2020-06-06
 */
public interface StoreProductMapper 
{
    /**
     * 查询商品
     * 
     * @param id 商品ID
     * @return 商品
     */
    public StoreProduct selectStoreProductById(String id);

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
    public int insertStoreProduct(StoreProduct storeProduct);

    /**
     * 修改商品
     * 
     * @param storeProduct 商品
     * @return 结果
     */
    public int updateStoreProduct(StoreProduct storeProduct);

    /**
     * 删除商品
     * 
     * @param id 商品ID
     * @return 结果
     */
    public int deleteStoreProductById(String id);

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStoreProductByIds(String[] ids);

    int changeIsShow(@Param("id") String id, @Param("isShow") Integer isShow);
}
