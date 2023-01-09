package com.wangyp.petmall.service.impl;

import com.wangyp.petmall.entity.*;
import com.wangyp.petmall.mapper.OrderMapper;
import com.wangyp.petmall.service.api.IAddressService;
import com.wangyp.petmall.service.api.ICartService;
import com.wangyp.petmall.service.api.IOrderService;
import com.wangyp.petmall.util.exception.InsertException;
import com.wangyp.petmall.util.exception.OrderNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: Wangyp
 * @Date: 2023/1/4 11:26
 * @Description: *
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ICartService cartService;

    @Transactional
    @Override
    public Order create(Integer aid, Integer[] cids, Integer uid, String username) {

        System.out.println( aid + " " + cids + " " + uid + " " + username );
        // 创建当前时间对象
        Date now = new Date();

        // 根据cids查询所勾选的购物车列表中的数据
        List<CartVO> carts = cartService.getVOByCids(uid, cids);

        // 计算这些商品的总价
        long totalPrice = 0;
        for (CartVO cart : carts) {
            totalPrice += cart.getRealPrice() * cart.getNum();
        }

        // 创建订单数据对象
        Order order = new Order();
        // 补全数据：uid
        order.setUid(uid);
        // 查询收货地址数据
        Address address = addressService.getByAid(aid, uid);
        // 补全数据：收货地址相关的6项
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvCity(address.getCityName());
        order.setRecvArea(address.getAreaName());
        order.setRecvAddress(address.getAddress());
        // 补全数据：totalPrice
        order.setTotalPrice(totalPrice);
        // 补全数据：status
        order.setStatus(0);
        // 补全数据：下单时间
        order.setOrderTime(now);
        // 补全数据：日志
        order.setCreatedUser(username);
        order.setCreatedTime(now);
        order.setModifiedUser(username);
        order.setModifiedTime(now);
        // 插入订单数据
        Integer rows1 = orderMapper.insertOrder(order);
        if (rows1 != 1) {
            throw new InsertException("插入订单数据时出现未知错误，请联系系统管理员");
        }

        // 遍历carts，循环插入订单商品数据
        for (CartVO cart : carts) {
            // 创建订单商品数据
            OrderItem item = new OrderItem();
            // 补全数据：setOid(order.getOid())
            item.setOid(order.getOid());
            // 补全数据：pid, title, image, price, num
            item.setPid(cart.getPid());
            item.setTitle(cart.getTitle());
            item.setImage(cart.getImage());
            item.setPrice(cart.getRealPrice());
            item.setNum(cart.getNum());
            // 补全数据：4项日志
            item.setCreatedUser(username);
            item.setCreatedTime(now);
            item.setModifiedUser(username);
            item.setModifiedTime(now);
            // 插入订单商品数据
            Integer rows2 = orderMapper.insertOrderItem(item);
            if (rows2 != 1) {
                throw new InsertException("插入订单商品数据时出现未知错误，请联系系统管理员");
            }
        }

        // 返回
        return order;
    }

    @Override
    public List<Order> getOrderList() {

        Integer orderNums = orderMapper.getOrderId();
        return null;
    }

    @Override
    public List<OrderVo> queryOrderVoByOid(Integer oid) {
        List<OrderVo> orderVos = orderMapper.queryOrderVoByOid(oid);
        for (OrderVo vo: orderVos) {
            //根据每个订单的oid查询地址信息
            Address address = addressService.queryAddressByAid(vo.getAid());
            //补全OrderVo值对象中的空白字段
            vo.setZip(address.getZip());
            vo.setPhone(address.getPhone());
            vo.setProvinceName(address.getProvinceName());
            vo.setCityName(address.getCityName());
            vo.setAreaName(address.getAreaName());
            vo.setAddress(address.getAddress());
        }
        return orderVos;
    }

    @Override
    public List<OrderVo> queryOrderVoByUid(Integer uid,Integer status) {
        List<OrderVo> orderVos = orderMapper.queryOrderVoByUid(uid,status);
        if (orderVos.size() == 0){
            throw new OrderNotExistsException("查询订单为空");
        }
        return orderVos;
    }
}
