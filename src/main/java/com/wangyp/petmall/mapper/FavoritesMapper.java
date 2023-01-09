package com.wangyp.petmall.mapper;

import com.wangyp.petmall.entity.Favorites;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Wangyp
 * @Date: 2023/1/6 20:16
 * @Description: *
 */
public interface FavoritesMapper {

    int addFavorites(Favorites favorites);

    List<Favorites> queryFavoritesByUidAndStatus(@Param("uid") Integer uid,
                                                 @Param("status") Integer status);

    int updateFavoritesStatus(@Param("status") Integer status,
                              @Param("fid") Integer fid,
                              @Param("uid") Integer uid);

    int deleteFavorites(@Param("fid") Integer fid,
                        @Param("uid") Integer uid);

    int findFavorites(@Param("uid") Integer uid,
                      @Param("pid") Integer pid);
}
