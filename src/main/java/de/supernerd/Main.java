package de.supernerd;

import de.supernerd.shop.Order;
import de.supernerd.shop.OrderListRepo;
import de.supernerd.shop.Product;
import de.supernerd.shop.ShopService;

public class Main {
    public static void main(String[] args) {
        ProducTrepo producTrepo = new ProducTrepo();

        Product product1 = new Product(5546, "HDMI Kabel", "p1.jpg", 12.55);
        Product product2 = new Product(5646, "Grafikkarte", "p2.jpg", 1500.00);
        Product product3 = new Product(4646, "Soundkarte", "p3.jpg", 350.00);
        Product product4 = new Product(5334, "Festplatte", "p4.jpg", 150.00);

        producTrepo.add(product1);
        producTrepo.add(product2);
        producTrepo.add(product3);
        producTrepo.add(product4);

        OrderListRepo orderListRepo = new OrderListRepo();
        Order order1 = new Order(5546, "12.12.2002", producTrepo.getProducts(), "Ahornweg 1, 5555 Muisterhausen", "Max Mustermann");
        Order order2 = new Order(478, "23.01.2005", producTrepo.getProducts(), "Andreas-Hofer-Straße 6, 44563 München", "Fritzchen");
        Order order3 = new Order(74233, "04.02.2008", producTrepo.getProducts(), "Friedrichstraße 11, 87437 Kempten", "Moritz");
        Order order4 = new Order(556, "28.05.2015", producTrepo.getProducts(), "Maisenstraße 22, 44666 Frankfurt", "Friedrich");

        Order order5 = new Order(3356, "28.06.2015", producTrepo.getProducts(), "Maistraße 55, 44722 Frankfurt", "Friedrich");

        orderListRepo.add(order1);
        orderListRepo.add(order2);
        orderListRepo.add(order3);
        orderListRepo.add(order4);
        orderListRepo.add(order5);

        ShopService shopService = new ShopService();
        if(shopService.newOrder(order1)) {
            System.out.println("Bestellung wurde erfolgreich übermittelt!");
        } else {
            System.out.println("Bestellung enthält keine Produkte und konnte deshalb nicht übermittelt werden!");
        }
    }
}
