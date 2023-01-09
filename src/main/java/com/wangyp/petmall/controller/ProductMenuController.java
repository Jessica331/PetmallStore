package com.wangyp.petmall.controller;

import com.wangyp.petmall.entity.Product;
import com.wangyp.petmall.entity.ProductMenu;
import com.wangyp.petmall.service.api.IProductMenuService;
import com.wangyp.petmall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Wangyp
 * @Date: 2023/1/4 18:28
 * @Description: *
 */
@RestController
@RequestMapping("productmenus")
public class ProductMenuController extends BaseController {

    @Autowired
    private IProductMenuService productMenuService;

    @GetMapping({"", "/"})
    public JsonResult<List<ProductMenu>> getProductMenu() {
        List<ProductMenu> data = productMenuService.getProductMenu();
        return new JsonResult<>(OK, data);
    }
}
