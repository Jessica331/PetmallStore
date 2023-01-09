package com.wangyp.petmall.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Wangyp
 * @Date: 2023/1/2 18:06
 * @Description: *
 */
@Data
public class BaseEntity implements Serializable {
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;
}
