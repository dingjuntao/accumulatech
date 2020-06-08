package com.accumulatech.project.shopconfig.banner.service;

import com.accumulatech.project.shopconfig.banner.domain.HomeBanner;
import com.accumulatech.project.shopconfig.banner.domain.HomeBannerVo;

import java.util.List;

/**
 * 首页幻灯片Service接口
 * 
 * @author dingjt
 * @date 2020-06-07
 */
public interface IHomeBannerService 
{
    /**
     * 查询首页幻灯片
     * 
     * @param id 首页幻灯片ID
     * @return 首页幻灯片
     */
    public HomeBannerVo selectHomeBannerById(String id);

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
    public int insertHomeBanner(HomeBannerVo homeBanner);

    /**
     * 修改首页幻灯片
     * 
     * @param homeBanner 首页幻灯片
     * @return 结果
     */
    public int updateHomeBanner(HomeBannerVo homeBanner);

    /**
     * 批量删除首页幻灯片
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHomeBannerByIds(String ids);

    /**
     * 删除首页幻灯片信息
     * 
     * @param id 首页幻灯片ID
     * @return 结果
     */
    public int deleteHomeBannerById(String id);
}
