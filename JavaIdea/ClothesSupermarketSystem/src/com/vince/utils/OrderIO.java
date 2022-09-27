package com.vince.utils;

import com.vince.bean.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderIO {
    private static List<Order> orders = new ArrayList<>();
    private static final String ORDER_FILE = "order.obj";

    public void add(Order order) throws BusinessException {
        orders.add(order);
        writeOrders();
    }

    public List<Order> list() throws BusinessException {
        readOrders();
        return orders;
    }

    public Order findByOrderId(int orderId) throws BusinessException {
        Order order = null;
        readOrders();
        int oid;
        for (Order o : orders) {
            oid = o.getOrderId();
            if (oid == orderId) {
                order = o;
                break;
            }
        }
        return order;
    }

    public boolean writeOrders() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ORDER_FILE));
            out.writeObject(orders);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean readOrders() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(ORDER_FILE));
            orders = (List<Order>) in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
