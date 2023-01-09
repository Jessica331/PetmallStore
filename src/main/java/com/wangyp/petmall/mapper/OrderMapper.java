package com.wangyp.petmall.mapper;

import com.wangyp.petmall.entity.Order;
import com.wangyp.petmall.entity.OrderItem;
import com.wangyp.petmall.entity.OrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Wangyp
 * @Date: 2023/1/4 11:24
 * @Description: *
 */
public interface OrderMapper {

    /**
     * 插入订单数据
     * @param order 订单数据
     * @return 受影响的行数
     */
    Integer insertOrder(Order order);

    /**
     * 插入订单商品数据
     * @param orderItem 订单商品数据
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);

    Integer getOrderId();

    List<OrderVo> queryOrderVoByOid(Integer oid);

    List<OrderVo> queryOrderVoByUid(@Param("uid") Integer uid,
                                    @Param("status") Integer status);
}

