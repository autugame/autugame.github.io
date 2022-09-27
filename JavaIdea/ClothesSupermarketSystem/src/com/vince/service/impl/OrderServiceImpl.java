package com.vince.service.impl;

import com.vince.bean.Order;
import com.vince.service.OrderService;
import com.vince.utils.BusinessException;
import com.vince.utils.OrderIO;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderIO orderIO = new OrderIO();

    @Override
    public void buyProduct(Order o) throws BusinessException {
        orderIO.add(o);
    }

    @Override
    public List<Order> list() throws BusinessException {
        return orderIO.list();
    }

    @Override
    public Order findById(int orderId) throws BusinessException {
        return orderIO.findByOrderId(orderId);
    }
}
