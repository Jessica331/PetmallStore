package com.wangyp.petmall.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Wangyp
 * @Date: 2023/1/3 22:22
 * @Description: *
 */
@Data
public class District implements Serializable {

    private Integer id;
    private String parent;
    private String code;
    private String name;

}
