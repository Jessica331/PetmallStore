package com.wangyp.petmall.service.impl;

import com.wangyp.petmall.entity.Product;
import com.wangyp.petmall.entity.ProductMenu;
import com.wangyp.petmall.mapper.ProductMenuMapper;
import com.wangyp.petmall.service.api.IProductMenuService;
import com.wangyp.petmall.service.api.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Wangyp
 * @Date: 2023/1/4 18:30
 * @Description: *
 */
@Service
public class ProductMenuServiceImpl implements IProductMenuService {

    @Autowired
    private ProductMenuMapper productMenuMapper;

    @Override
    public List<ProductMenu> getProductMenu() {
        List<ProductMenu> list = productMenuMapper.getProductMenu();
        return list;
    }

}
