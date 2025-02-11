package de.supernerd.shop;

import de.supernerd.shop.interfaces.OrderRepo;

public class ShopService {
    private OrderRepo orderRepo;

    public ShopService() {

    }

    public ShopService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public String toString() {
        return "ShopService{}";
    }

    public boolean newOrder(Order order) {
       if(order != null && !order.orderProducts().isEmpty()) {
           return true;
       }

       return false;
    }


}
