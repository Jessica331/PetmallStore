package com.wangyp.petmall.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Wangyp
 * @Date: 2023/1/4 11:04
 * @Description: *
 */
@Data
public class CartVO implements Serializable {

    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;
    private String title;
    private Long realPrice;
    private String image;
}
