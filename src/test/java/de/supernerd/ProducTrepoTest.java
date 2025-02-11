package de.supernerd;

import de.supernerd.shop.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProducTrepoTest {

    ProducTrepo producTrepo = new ProducTrepo();

    Product product1 = new Product(5546, "HDMI Kabel", "p1.jpg", 12.55);
    Product product2 = new Product(5646, "Grafikkarte", "p2.jpg", 1500.00);
    Product product3 = new Product(4646, "Soundkarte", "p3.jpg", 350.00);
    Product product4 = new Product(5334, "Festplatte", "p4.jpg", 150.00);


    public ProducTrepoTest() {

    }

    @Test
    void addProduct_to_arrayList_products() {
        producTrepo.add(product1);
        producTrepo.add(product2);
        producTrepo.add(product3);
        producTrepo.add(product4);

        Assertions.assertEquals(4, producTrepo.getProducts().size());

    }

    @Test
    void removeProduct_from_arrayList_products_is_deleted() {

        producTrepo.add(product1);
        producTrepo.add(product2);
        producTrepo.add(product3);
        producTrepo.add(product4);

        Assertions.assertEquals(4, producTrepo.getProducts().size());
        Assertions.assertTrue(producTrepo.remove(product2.articleNumber()));
        Assertions.assertEquals(3, producTrepo.getProducts().size());
    }

    @Test
    void removeProduct_from_arrayList_products_not_deleted() {
        producTrepo.add(product1);
        producTrepo.add(product2);
        producTrepo.add(product3);
        producTrepo.add(product4);

        Assertions.assertEquals(4, producTrepo.getProducts().size());
        Assertions.assertFalse(producTrepo.remove(4455));
        Assertions.assertEquals(4, producTrepo.getProducts().size());

    }

    @Test
    void getSingleProduct_return_single_product_from_ArrayList() {
        producTrepo.add(product1);
        producTrepo.add(product2);
        producTrepo.add(product3);
        producTrepo.add(product4);

        Product expect = product3;

        Assertions.assertEquals(expect, producTrepo.getSingleProduct(product3.articleNumber()));

    }

    @Test
    void getSingleProduct_return_single_product_not_found() {
        producTrepo.add(product1);
        producTrepo.add(product2);
        producTrepo.add(product3);
        producTrepo.add(product4);

        Assertions.assertNull(producTrepo.getSingleProduct(55887));

    }

    @Test
    void getAllProducts_return_ArrayList() {
        producTrepo.add(product1);
        producTrepo.add(product2);
        producTrepo.add(product3);
        producTrepo.add(product4);

        int expect = 4;

        Assertions.assertEquals(expect, producTrepo.getAllProducts().size());
    }
}