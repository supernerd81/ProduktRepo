package de.supernerd.shop;

import de.supernerd.shop.interfaces.OrderRepo;

import java.util.*;

public class OrderMapRepo implements OrderRepo {

    Map<Integer, Order> orders;

    public OrderMapRepo(HashMap<Integer, Order> orders) {
        this.orders = orders;
    }

    public OrderMapRepo() {
        orders = new HashMap<>();
    }

    @Override
    public ArrayList<Order> getAll() {

        if(!orders.isEmpty()) {
            return new ArrayList<>(orders.values());
        }

        return null;
    }

    @Override
    public void add(Order order) {
        orders.put(order.orderNumber(), order);
    }

    @Override
    public Order getSingle(int orderNumber) {
        if(orders.containsKey(orderNumber)) {
            return orders.get(orderNumber);
        }

        return null;
    }

    @Override
    public boolean delete(Order order) {
        if(orders.remove(order.orderNumber(), order)) {
            return true;
        }

        return false;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(HashMap<Integer, Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderMapRepo that = (OrderMapRepo) o;
        return Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orders);
    }

    @Override
    public String toString() {
        return "OrderMapRepo{" +
                "orders=" + orders +
                '}';
    }
}
