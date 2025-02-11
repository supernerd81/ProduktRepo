package de.supernerd.shop;

import java.util.ArrayList;

public record Order(
        int orderNumber,
        String orderDate,
        ArrayList<Product> orderProducts,
        String deliveryAddress,
        String deliveryName
) {
}
