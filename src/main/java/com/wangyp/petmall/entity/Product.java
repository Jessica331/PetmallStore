package com.wangyp.petmall.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Wangyp
 * @Date: 2023/1/4 10:33
 * @Description: *
 */
@Data
public class Product extends BaseEntity implements Serializable {
    private Integer id;
    private Integer categoryId;
    private String itemType;
    private String title;
    private String sellPoint;
    private Long price;
    private Integer num;
    private String image;
    private Integer status;
    private Integer priority;
}
