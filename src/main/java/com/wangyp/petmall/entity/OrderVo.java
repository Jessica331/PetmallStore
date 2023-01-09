package com.wangyp.petmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: Wangyp
 * @Date: 2023/1/9 17:18
 * @Description: *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo {
    private Integer oid;
    private Integer aid;
    private String recvName;
    private String zip;
    private String phone;
    private String provinceName;
    private String cityName;
    private String areaName;
    private String address;
    private Long totalPrice;
    private Integer status;
    private Date orderTime;
    private Date payTime;
    private String image;
    private String title;
    private Long price;
    private Integer num;
}

