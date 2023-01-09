package com.wangyp.petmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyp.petmall.entity.Favorites;
import com.wangyp.petmall.entity.Product;
import com.wangyp.petmall.mapper.ProductMapper;
import com.wangyp.petmall.service.api.IAddressService;
import com.wangyp.petmall.service.api.IProductService;
import com.wangyp.petmall.util.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Wangyp
 * @Date: 2023/1/4 10:37
 * @Description: *
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product findById(Integer id) {
        // 根据参数id调用私有方法执行查询，获取商品数据
        Product product = productMapper.findById(id);
        // 判断查询结果是否为null
        if (product == null) {
            // 是：抛出ProductNotFoundException
            throw new ProductNotFoundException("尝试访问的商品数据不存在");
        }
        // 将查询结果中的部分属性设置为null
        product.setPriority(null);
        product.setCreatedUser(null);
        product.setCreatedTime(null);
        product.setModifiedUser(null);
        product.setModifiedTime(null);
        // 返回查询结果
        return product;
    }

    @Override
    public List<Product> findNewList() {
        List<Product> list = productMapper.findNewList();
        return setNull(list);
    }

    @Override
    public List<Product> findHotList() {
        List<Product> list = productMapper.findHotList();
        return setNull(list);
    }

    @Override
    public PageInfo<Product> findroductList(Integer pageNum, Integer pageSize, String keyWord) {
        //开启分页功能，pageNum是当前页，pageSize是每页显示的数据量，这两个值都可以选择让前端传或者自己调整
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = productMapper.findroductList(keyWord);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return pageInfo;
    }

    private List<Product> setNull(List<Product> list) {
        for (Product product : list) {
            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedUser(null);
            product.setModifiedTime(null);
        }
        return list;
    }
}
