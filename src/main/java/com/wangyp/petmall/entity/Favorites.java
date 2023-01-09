package com.wangyp.petmall.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Wangyp
 * @Date: 2023/1/6 19:57
 * @Description: *
 */
@Data
public class Favorites  extends BaseEntity implements Serializable{

    private Integer fid;
    private Integer uid;
    private Integer pid;
    private String image;
    private Long price;
    private String title;
    private String sellPoint;
    private Integer status;

}