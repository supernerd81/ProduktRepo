package de.supernerd.shop;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class OrderListRepo {
    private ArrayList<Order> orders;

    public OrderListRepo() {
        orders = new ArrayList<>();
    }

    public OrderListRepo(ArrayList orders) {
        this.orders = orders;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orders=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderListRepo that = (OrderListRepo) o;
        return Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orders);
    }


    public boolean delete(Order order) {

        if(orders.remove(order)) {
            return true;
        }

        return false;
    }

    public Order geetSingleOrder(int orderNumber) {
        for(Order order : orders) {
            if(order.orderNumber() == orderNumber) {
                return order;
            }
        }

        return null;
    }

    public ArrayList<Order> getAllOrders() {
        if(!orders.isEmpty()) {
            return orders;
        }

        return null;
    }
}
