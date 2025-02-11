package de.supernerd;

import de.supernerd.shop.Product;

import java.util.ArrayList;
import java.util.Objects;

public class ProductRepo {
    private ArrayList<Product> products;

    public ProductRepo() {
        this.products = new ArrayList<>();
    }

    public void add(Product product) {
        products.add(product);
    }

    public boolean remove(int articleNumber) {
        for(Product product : products) {
            if(product.articleNumber() == articleNumber) {
                products.remove(product);
                return true;
            }
        }

        return false;
    }

    public Product getSingleProduct(int articleNumber) {
        for(Product product : products) {
            if(product.articleNumber() == articleNumber) {
                return product;
            }
        }

        return null;
    }

    public ArrayList<Product> getAllProducts() {
        return products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(products);
    }
}
