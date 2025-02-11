package de.supernerd.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShopServiceTest {
    Product product1 = new Product(5546, "HDMI Kabel", "p1.jpg", 12.55);
    Product product2 = new Product(5646, "Grafikkarte", "p2.jpg", 1500.00);

    ArrayList<Product> orderProducts = new ArrayList<>();

    @Test
    void shopService_new_order_is_null_return_false() {
        ShopService shopService = new ShopService();

        Assertions.assertFalse(shopService.newOrder(null));
    }

    @Test
    void shopService_new_order_isNot_null_return_true() {

        orderProducts.add(product1);
        orderProducts.add(product2);

        Order order = new Order(5546, "12.12.2002", orderProducts, "Ahornweg 1, 5555 Muisterhausen", "Max Mustermann");

        ShopService shopService = new ShopService();

        Assertions.assertTrue(shopService.newOrder(order));
    }
}
