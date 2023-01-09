package com.wangyp.petmall.service.api;

import com.wangyp.petmall.entity.Order;
import com.wangyp.petmall.entity.OrderVo;

import java.util.List;

/**
 * @Author: Wangyp
 * @Date: 2023/1/4 11:25
 * @Description: *
 */
public interface IOrderService {
    /**
     * 创建订单
     * @param aid 收货地址的id
     * @param cids 即将购买的商品数据在购物车表中的id
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @return 成功创建的订单数据
     */
    Order create(Integer aid, Integer[] cids, Integer uid, String username);

    List<Order> getOrderList();

    List<OrderVo> queryOrderVoByOid(Integer oid);

    List<OrderVo> queryOrderVoByUid(Integer uid, Integer status);
}
