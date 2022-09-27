package com.vince.service;

import com.vince.bean.Order;
import com.vince.utils.BusinessException;

import java.net.BindException;
import java.util.List;

public interface OrderService {
    public void buyProduct(Order o) throws BusinessException;
    public List<Order> list() throws BusinessException;
    public Order findById(int orderId) throws BusinessException;
}
