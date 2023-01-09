package com.wangyp.petmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyp.petmall.entity.Favorites;
import com.wangyp.petmall.entity.Product;
import com.wangyp.petmall.mapper.FavoritesMapper;
import com.wangyp.petmall.service.api.IFavoritesService;
import com.wangyp.petmall.service.api.IProductService;
import com.wangyp.petmall.util.exception.InsertException;
import com.wangyp.petmall.util.exception.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Wangyp
 * @Date: 2023/1/6 20:15
 * @Description: *
 */
@Service
public class FavoritesServiceImpl implements IFavoritesService {

    @Autowired
    private FavoritesMapper favoritesMapper;

    @Autowired
    protected IProductService productService;

    @Override
    public int addFavorites(Integer uid,Integer pid) {
        Favorites favorites = new Favorites();
        if (favoritesMapper.findFavorites(uid, pid) > 0 ) {
            throw new InsertException("该商品已被收藏");
        }

        //根据pid查询商品信息
        Product product = productService.findById(pid);

        //填充favorites对象空白字段
        favorites.setUid(uid);
        favorites.setPid(pid);
        favorites.setImage(product.getImage());
        favorites.setPrice(product.getPrice());
        favorites.setTitle(product.getTitle());
        favorites.setSellPoint(product.getSellPoint());
        favorites.setStatus(1);

        int result = favoritesMapper.addFavorites(favorites);
        if (result == 0){
            throw new InsertException("服务器异常，收藏商品失败");
        }

        //取出fid返回给前端页面，以便在搜索界面取消收藏使用
        return favorites.getFid();
    }

    @Override
    public PageInfo<Favorites> queryFavorites(Integer uid, Integer pageNum, Integer pageSize, Integer status) {
        //开启分页功能，pageNum是当前页，pageSize是每页显示的数据量，这两个值都可以选择让前端传或者自己调整
        PageHelper.startPage(pageNum, pageSize);
        List<Favorites> favorites = favoritesMapper.queryFavoritesByUidAndStatus(uid, status);
        PageInfo<Favorites> pageInfo = new PageInfo<>(favorites);
        return pageInfo;
    }

    @Override
    public int updateFavoritesStatus(Integer status, Integer fid, Integer uid) {
        int result = favoritesMapper.deleteFavorites(fid, uid);

        if (result == 0){
            throw new UpdateException("服务器异常，取消收藏失败");
        }
        return result;
    }


}
