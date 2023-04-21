package bakery;

import products.Product;

import java.util.ArrayList;

public interface BakeryInterface {
    String addProduct(String name, int bakePrice, int sellPrice);
    ArrayList<Product> listProducts();
    String removeProduct(String name);

    String bakeProduct(String name, int amount);

    String sellProduct(String name, int amount);
}
