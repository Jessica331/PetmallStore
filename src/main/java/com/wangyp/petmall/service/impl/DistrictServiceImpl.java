package com.wangyp.petmall.service.impl;

import com.wangyp.petmall.entity.District;
import com.wangyp.petmall.mapper.DistrictMapper;
import com.wangyp.petmall.service.api.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Wangyp
 * @Date: 2023/1/3 22:26
 * @Description: *
 */
@Service
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        List<District> list = districtMapper.findByParent(parent);
        for (District district : list) {
            district.setId(null);
            district.setParent(null);
        }
        return list;
    }

    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }
}
