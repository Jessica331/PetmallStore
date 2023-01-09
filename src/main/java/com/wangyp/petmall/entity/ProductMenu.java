package com.wangyp.petmall.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Wangyp
 * @Date: 2023/1/4 18:25
 * @Description: *
 */
@Data
public class ProductMenu extends BaseEntity implements Serializable {

    public Integer id;
    public Integer parent_id;
    public String name;
    public Integer status;
    public Integer sort_order;
    public Integer is_parent;

}
