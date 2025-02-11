package de.supernerd.shop;

import de.supernerd.shop.interfaces.OrderRepo;

import java.util.ArrayList;
import java.util.Objects;

public class OrderListRepo implements OrderRepo {
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

    @Override
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

    @Override
    public Order getSingle(int orderNumber) {
        for(Order order : orders) {
            if(order.orderNumber() == orderNumber) {
                return order;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Order> getAll() {
        if(!orders.isEmpty()) {
            return orders;
        }

        return null;
    }
}
