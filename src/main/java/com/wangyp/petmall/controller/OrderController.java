package com.wangyp.petmall.controller;

import com.wangyp.petmall.entity.Order;
import com.wangyp.petmall.entity.OrderVo;
import com.wangyp.petmall.service.api.IOrderService;
import com.wangyp.petmall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: Wangyp
 * @Date: 2023/1/4 11:27
 * @Description: *
 */
@RestController
@RequestMapping("orders")
public class OrderController extends BaseController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping("create")
    public JsonResult<Order> create(Integer aid, Integer[] cids, HttpSession session) {
        // 从Session中取出uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行业务
        Order data = orderService.create(aid, cids, uid, username);
        // 返回成功与数据
        return new JsonResult<Order>(OK, data);
    }

    @GetMapping("/queryOrderVo")
    public JsonResult<List<OrderVo>>  queryOrderVo(Integer oid){
        List<OrderVo> orderVos = orderService.queryOrderVoByOid(oid);

        return new JsonResult<>(OK,orderVos);
    }

    @GetMapping("/uidOrderVo")
    public JsonResult<List<OrderVo>>  queryOrderVoByUid(HttpSession session,Integer status){
        Integer uid = getUidFromSession(session);
        List<OrderVo> orderVos = orderService.queryOrderVoByUid(uid,status);

        return new JsonResult<>(OK,orderVos);
    }

}
