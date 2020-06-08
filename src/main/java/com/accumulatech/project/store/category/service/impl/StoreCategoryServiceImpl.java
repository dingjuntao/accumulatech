package com.accumulatech.project.store.category.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.accumulatech.framework.web.domain.ZtreeTwo;
import com.accumulatech.project.store.category.mapper.StoreCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accumulatech.project.store.category.domain.StoreCategory;
import com.accumulatech.project.store.category.service.IStoreCategoryService;
import com.accumulatech.common.utils.text.Convert;

/**
 * 商品分类Service业务层处理
 *
 * @author dingjt
 * @date 2020-06-06
 */
@Service
public class StoreCategoryServiceImpl implements IStoreCategoryService {
    @Autowired
    private StoreCategoryMapper storeCategoryMapper;

    /**
     * 查询商品分类
     *
     * @param id 商品分类ID
     * @return 商品分类
     */
    @Override
    public StoreCategory selectStoreCategoryById(String id) {
        return storeCategoryMapper.selectStoreCategoryById(id);
    }

    /**
     * 查询商品分类列表
     *
     * @param storeCategory 商品分类
     * @return 商品分类
     */
    @Override
    public List<StoreCategory> selectStoreCategoryList(StoreCategory storeCategory) {
        return storeCategoryMapper.selectStoreCategoryList(storeCategory);
    }

    /**
     * 新增商品分类
     *
     * @param storeCategory 商品分类
     * @return 结果
     */
    @Override
    public int insertStoreCategory(StoreCategory storeCategory) {
        storeCategory.preInsert();
        return storeCategoryMapper.insertStoreCategory(storeCategory);
    }

    /**
     * 修改商品分类
     *
     * @param storeCategory 商品分类
     * @return 结果
     */
    @Override
    public int updateStoreCategory(StoreCategory storeCategory) {
        storeCategory.preUpdate();
        return storeCategoryMapper.updateStoreCategory(storeCategory);
    }

    /**
     * 删除商品分类对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStoreCategoryByIds(String ids) {
        return storeCategoryMapper.deleteStoreCategoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品分类信息
     *
     * @param id 商品分类ID
     * @return 结果
     */
    @Override
    public int deleteStoreCategoryById(String id) {
        return storeCategoryMapper.deleteStoreCategoryById(id);
    }

    @Override
    public List<ZtreeTwo> selectCategoryTree(StoreCategory storeCategory) {
        List<StoreCategory> list = storeCategoryMapper.selectStoreCategoryList(storeCategory);
        List<ZtreeTwo> ztrees = initZtree(list);
        return ztrees;
    }

    /**
     * 对象转树
     */
    public List<ZtreeTwo> initZtree(List<StoreCategory> list) {
        List<ZtreeTwo> ztrees = new ArrayList<ZtreeTwo>();
        for (StoreCategory sc : list) {
            ZtreeTwo ztree = new ZtreeTwo();
            ztree.setId(sc.getId());
            ztree.setpId(sc.getParentId());
            ztree.setName(sc.getClassifyName());
            ztree.setTitle(sc.getClassifyName());
            ztree.setChecked(false);
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
