package de.supernerd.shop;

public record Product(
        int articleNumber,
        String name,
        String image,
        double price
) {
}
