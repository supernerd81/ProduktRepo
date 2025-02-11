package de.supernerd.shop.interfaces;

import de.supernerd.shop.Order;

import java.util.ArrayList;

public interface OrderRepo {
    ArrayList<Order> getAll();
    void add(Order order);
    Order getSingle(int orderNumber);
    boolean delete(Order order);
}
