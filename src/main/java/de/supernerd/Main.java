package de.supernerd;

import de.supernerd.shop.Product;

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
    }
}
