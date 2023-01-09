package com.wangyp.petmall.controller;

import com.github.pagehelper.PageInfo;
import com.wangyp.petmall.entity.Address;
import com.wangyp.petmall.entity.Favorites;
import com.wangyp.petmall.entity.Product;
import com.wangyp.petmall.service.api.IProductService;
import com.wangyp.petmall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Author: Wangyp
 * @Date: 2023/1/4 10:38
 * @Description: *
 */
@RestController
@RequestMapping("products")
public class ProductController extends BaseController {

    @Autowired
    private IProductService productService;


    @RequestMapping("product_list")
    public JsonResult<PageInfo<Product>> getProductList(Integer pageNum, Integer pageSize, String keyWord) throws UnsupportedEncodingException {
        keyWord = java.net.URLDecoder.decode(keyWord, "UTF-8");
        PageInfo<Product> data = productService.findroductList(pageNum, pageSize, keyWord);
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("hot_list")
    public JsonResult<List<Product>> getHotList() {
        List<Product> data = productService.findHotList();
        return new JsonResult<List<Product>>(OK, data);
    }

    @RequestMapping("new_list")
    public JsonResult<List<Product>> getNewList() {
        List<Product> data = productService.findNewList();
        return new JsonResult<List<Product>>(OK, data);
    }

    @GetMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id) {
        // 调用业务对象执行获取数据
        Product data = productService.findById(id);
        // 返回成功和数据
        return new JsonResult<Product>(OK, data);
    }
}
