package com.wangyp.petmall.service.api;

import com.github.pagehelper.PageInfo;
import com.wangyp.petmall.entity.Favorites;

/**
 * @Author: Wangyp
 * @Date: 2023/1/6 20:14
 * @Description: *
 */
public interface IFavoritesService {

    int addFavorites(Integer uid,Integer pid);

    PageInfo<Favorites> queryFavorites(Integer uid, Integer pageNum, Integer pageSize, Integer status);

    int updateFavoritesStatus(Integer status,Integer fid,Integer uid);
}
