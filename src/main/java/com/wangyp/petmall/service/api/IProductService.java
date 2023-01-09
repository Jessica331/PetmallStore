package com.wangyp.petmall.service.api;

import com.github.pagehelper.PageInfo;
import com.wangyp.petmall.entity.Product;

import java.util.List;

/**
 * @Author: Wangyp
 * @Date: 2023/1/4 10:36
 * @Description: *
 */
public interface IProductService {

    /**
     * 查询热销商品的前四名
     * @return 热销商品前四名的集合
     */
    List<Product> findHotList();

    /**
     * 根据商品id查询商品详情
     * @param id 商品id
     * @return 匹配的商品详情，如果没有匹配的数据则返回null
     */
    Product findById(Integer id);


    /**
     * 查询新商品的前四名
     * @return 热销商品前四名的集合
     */
    List<Product> findNewList();


    PageInfo<Product> findroductList(Integer pageNum, Integer pageSize, String keyWord);
}
