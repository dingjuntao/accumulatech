package com.accumulatech.project.shopconfig.banner.mapper;

import com.accumulatech.project.shopconfig.banner.domain.HomeBanner;

import java.util.List;

/**
 * 首页幻灯片Mapper接口
 * 
 * @author dingjt
 * @date 2020-06-07
 */
public interface HomeBannerMapper 
{
    /**
     * 查询首页幻灯片
     * 
     * @param id 首页幻灯片ID
     * @return 首页幻灯片
     */
    public HomeBanner selectHomeBannerById(String id);

    /**
     * 查询首页幻灯片列表
     * 
     * @param homeBanner 首页幻灯片
     * @return 首页幻灯片集合
     */
    public List<HomeBanner> selectHomeBannerList(HomeBanner homeBanner);

    /**
     * 新增首页幻灯片
     * 
     * @param homeBanner 首页幻灯片
     * @return 结果
     */
    public int insertHomeBanner(HomeBanner homeBanner);

    /**
     * 修改首页幻灯片
     * 
     * @param homeBanner 首页幻灯片
     * @return 结果
     */
    public int updateHomeBanner(HomeBanner homeBanner);

    /**
     * 删除首页幻灯片
     * 
     * @param id 首页幻灯片ID
     * @return 结果
     */
    public int deleteHomeBannerById(String id);

    /**
     * 批量删除首页幻灯片
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHomeBannerByIds(String[] ids);
}
