package de.supernerd.shop;

public class ShopService {

    public boolean newOrder(Order order) {
       if(order != null && !order.orderProducts().isEmpty()) {
           return true;
       }

       return false;
    }
}
