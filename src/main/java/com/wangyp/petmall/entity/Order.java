package com.wangyp.petmall.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Wangyp
 * @Date: 2023/1/4 11:23
 * @Description: *
 */
@Data
public class Order extends BaseEntity implements Serializable {

    private Integer oid;
    private Integer uid;
    private String recvName;
    private String recvPhone;
    private String recvProvince;
    private String recvCity;
    private String recvArea;
    private String recvAddress;
    private Long totalPrice;
    private Integer status;
    private Date orderTime;
    private Date payTime;
}
