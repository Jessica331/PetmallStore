package com.wangyp.petmall.util;

import com.wangyp.petmall.util.constant.PetmallConstant;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: Wangyp
 * @Date: 2023/1/2 19:44
 * @Description: *
 */
@Getter
@Setter
public class JsonResult<E> implements Serializable {

    /** 状态码 */
    private Integer state;

    /** 状态描述信息 */
    private String message;

    /** 数据 */
    private E data;


    public JsonResult() {
        super();
    }

    public JsonResult(Integer state) {
        super();
        this.state = state;
    }

    /** 出现异常时调用 */
    public JsonResult(Throwable e) {
        super();
        // 获取异常对象中的异常信息
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        super();
        this.state = state;
        this.data = data;
    }

}
