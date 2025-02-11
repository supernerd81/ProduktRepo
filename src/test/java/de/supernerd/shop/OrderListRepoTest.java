package de.supernerd.shop;

import de.supernerd.ProducTrepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class OrderListRepoTest {

    ProducTrepo producTrepo = new ProducTrepo();

    Product product1 = new Product(5546, "HDMI Kabel", "p1.jpg", 12.55);
    Product product2 = new Product(5646, "Grafikkarte", "p2.jpg", 1500.00);
    Product product3 = new Product(4646, "Soundkarte", "p3.jpg", 350.00);
    Product product4 = new Product(5334, "Festplatte", "p4.jpg", 150.00);

    OrderListRepo orderListRepo = new OrderListRepo();

    ArrayList<Product> orderProducts = new ArrayList<>();

    @Test
    void addOrder_to_arrayList_products() {

        orderProducts.add(product1);
        orderProducts.add(product2);

        Order order1 = new Order(5546, "12.12.2002", orderProducts, "Ahornweg 1, 5555 Muisterhausen", "Max Mustermann");
        Order order2 = new Order(478, "23.01.2005", orderProducts, "Andreas-Hofer-Straße 6, 44563 München", "Fritzchen");
        Order order3 = new Order(74233, "04.02.2008", orderProducts, "Friedrichstraße 11, 87437 Kempten", "Moritz");
        Order order4 = new Order(556, "28.05.2015", orderProducts, "Maisenstraße 22, 44666 Frankfurt", "Friedrich");

        orderListRepo.add(order1);
        orderListRepo.add(order2);
        orderListRepo.add(order3);
        orderListRepo.add(order4);

        int expect = 4;

        Assertions.assertEquals(expect, orderListRepo.getOrders().size());
    }

    @Test
    void removeOrder_from_arrayList_order_is_deleted() {
        orderProducts.add(product1);
        orderProducts.add(product2);

        Order order1 = new Order(5546, "12.12.2002", orderProducts, "Ahornweg 1, 5555 Muisterhausen", "Max Mustermann");
        Order order2 = new Order(478, "23.01.2005", orderProducts, "Andreas-Hofer-Straße 6, 44563 München", "Fritzchen");
        Order order3 = new Order(74233, "04.02.2008", orderProducts, "Friedrichstraße 11, 87437 Kempten", "Moritz");
        Order order4 = new Order(556, "28.05.2015", orderProducts, "Maisenstraße 22, 44666 Frankfurt", "Friedrich");

        orderListRepo.add(order1);
        orderListRepo.add(order2);
        orderListRepo.add(order3);
        orderListRepo.add(order4);

        int expectBefore = 4;
        int expectAfter = 3;

        Assertions.assertEquals(expectBefore, orderListRepo.getOrders().size());
        orderListRepo.delete(order2);
        Assertions.assertEquals(expectAfter, orderListRepo.getOrders().size());

    }

    @Test
    void removeORder_from_arrayList_order_is_deleted_return_is_true() {
        orderProducts.add(product1);
        orderProducts.add(product2);

        Order order1 = new Order(5546, "12.12.2002", orderProducts, "Ahornweg 1, 5555 Muisterhausen", "Max Mustermann");
        Order order2 = new Order(478, "23.01.2005", orderProducts, "Andreas-Hofer-Straße 6, 44563 München", "Fritzchen");
        Order order3 = new Order(74233, "04.02.2008", orderProducts, "Friedrichstraße 11, 87437 Kempten", "Moritz");
        Order order4 = new Order(556, "28.05.2015", orderProducts, "Maisenstraße 22, 44666 Frankfurt", "Friedrich");

        orderListRepo.add(order1);
        orderListRepo.add(order2);
        orderListRepo.add(order3);
        orderListRepo.add(order4);

        Assertions.assertTrue(orderListRepo.delete(order3));
    }

    @Test
    void removeORder_from_arrayList_order_not_deleted_return_is_false() {
        orderProducts.add(product1);
        orderProducts.add(product2);

        Order order1 = new Order(5546, "12.12.2002", orderProducts, "Ahornweg 1, 5555 Muisterhausen", "Max Mustermann");
        Order order2 = new Order(478, "23.01.2005", orderProducts, "Andreas-Hofer-Straße 6, 44563 München", "Fritzchen");
        Order order3 = new Order(74233, "04.02.2008", orderProducts, "Friedrichstraße 11, 87437 Kempten", "Moritz");
        Order order4 = new Order(556, "28.05.2015", orderProducts, "Maisenstraße 22, 44666 Frankfurt", "Friedrich");

        Order order5 = new Order(3356, "28.06.2015", orderProducts, "Maistraße 55, 44722 Frankfurt", "Friedrich");

        orderListRepo.add(order1);
        orderListRepo.add(order2);
        orderListRepo.add(order3);
        orderListRepo.add(order4);

        Assertions.assertFalse(orderListRepo.delete(order5));
    }

    @Test
    void getSingleProduct_return_single_product_from_ArrayList() {
        orderProducts.add(product1);
        orderProducts.add(product2);

        Order order1 = new Order(5546, "12.12.2002", orderProducts, "Ahornweg 1, 5555 Muisterhausen", "Max Mustermann");
        Order order2 = new Order(478, "23.01.2005", orderProducts, "Andreas-Hofer-Straße 6, 44563 München", "Fritzchen");
        Order order3 = new Order(74233, "04.02.2008", orderProducts, "Friedrichstraße 11, 87437 Kempten", "Moritz");
        Order order4 = new Order(556, "28.05.2015", orderProducts, "Maisenstraße 22, 44666 Frankfurt", "Friedrich");

        orderListRepo.add(order1);
        orderListRepo.add(order2);
        orderListRepo.add(order3);
        orderListRepo.add(order4);

        Order singleOrderNumber = orderListRepo.geetSingleOrder(order3.orderNumber());

        Assertions.assertEquals(order3, singleOrderNumber);
    }

    @Test
    void getSingleOrder_return_single_order_not_found() {
        orderProducts.add(product1);
        orderProducts.add(product2);

        Order order1 = new Order(5546, "12.12.2002", orderProducts, "Ahornweg 1, 5555 Muisterhausen", "Max Mustermann");
        Order order2 = new Order(478, "23.01.2005", orderProducts, "Andreas-Hofer-Straße 6, 44563 München", "Fritzchen");
        Order order3 = new Order(74233, "04.02.2008", orderProducts, "Friedrichstraße 11, 87437 Kempten", "Moritz");
        Order order4 = new Order(556, "28.05.2015", orderProducts, "Maisenstraße 22, 44666 Frankfurt", "Friedrich");

        Order order5 = new Order(3356, "28.06.2015", orderProducts, "Maistraße 55, 44722 Frankfurt", "Friedrich");

        orderListRepo.add(order1);
        orderListRepo.add(order2);
        orderListRepo.add(order3);
        orderListRepo.add(order4);

        Order singleOrderNumber = orderListRepo.geetSingleOrder(order5.orderNumber());

        Assertions.assertNull(singleOrderNumber);
    }

    @Test
    void getAllProducts_return_ArrayList() {
            orderProducts.add(product1);
            orderProducts.add(product2);

            Order order1 = new Order(5546, "12.12.2002", orderProducts, "Ahornweg 1, 5555 Muisterhausen", "Max Mustermann");
            Order order2 = new Order(478, "23.01.2005", orderProducts, "Andreas-Hofer-Straße 6, 44563 München", "Fritzchen");
            Order order3 = new Order(74233, "04.02.2008", orderProducts, "Friedrichstraße 11, 87437 Kempten", "Moritz");
            Order order4 = new Order(556, "28.05.2015", orderProducts, "Maisenstraße 22, 44666 Frankfurt", "Friedrich");

            Order order5 = new Order(3356, "28.06.2015", orderProducts, "Maistraße 55, 44722 Frankfurt", "Friedrich");

            orderListRepo.add(order1);
            orderListRepo.add(order2);
            orderListRepo.add(order3);
            orderListRepo.add(order4);

            int expect = 4;

            Assertions.assertEquals(expect, orderListRepo.getAllOrders().size());
    }

    @Test
    void getAllProducts_return_ArrayList_is_null_When_empty() {
        Assertions.assertNull(orderListRepo.getAllOrders());
    }
}
