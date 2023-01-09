package com.wangyp.petmall.controller;

import com.wangyp.petmall.entity.District;
import com.wangyp.petmall.service.api.IDistrictService;
import com.wangyp.petmall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Wangyp
 * @Date: 2023/1/3 22:39
 * @Description: *
 */

@RequestMapping("districts")
@RestController
public class DistrictController extends BaseController {

    @Autowired
    private IDistrictService districtService;

    @GetMapping({"", "/"})
    public JsonResult<List<District>> getByParent(String parent) {
        List<District> data = districtService.getByParent(parent);
        return new JsonResult<>(OK, data);
    }
}