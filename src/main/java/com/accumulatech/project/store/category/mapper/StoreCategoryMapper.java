package com.accumulatech.project.store.category.mapper;

import java.util.List;
import com.accumulatech.project.store.category.domain.StoreCategory;

/**
 * 商品分类Mapper接口
 * 
 * @author dingjt
 * @date 2020-06-06
 */
public interface StoreCategoryMapper 
{
    /**
     * 查询商品分类
     * 
     * @param id 商品分类ID
     * @return 商品分类
     */
    public StoreCategory selectStoreCategoryById(String id);

    /**
     * 查询商品分类列表
     * 
     * @param storeCategory 商品分类
     * @return 商品分类集合
     */
    public List<StoreCategory> selectStoreCategoryList(StoreCategory storeCategory);

    /**
     * 新增商品分类
     * 
     * @param storeCategory 商品分类
     * @return 结果
     */
    public int insertStoreCategory(StoreCategory storeCategory);

    /**
     * 修改商品分类
     * 
     * @param storeCategory 商品分类
     * @return 结果
     */
    public int updateStoreCategory(StoreCategory storeCategory);

    /**
     * 删除商品分类
     * 
     * @param id 商品分类ID
     * @return 结果
     */
    public int deleteStoreCategoryById(String id);

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStoreCategoryByIds(String[] ids);
}
