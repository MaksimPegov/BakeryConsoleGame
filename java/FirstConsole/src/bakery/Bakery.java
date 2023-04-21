import products.Product;

import java.util.ArrayList;

public class Bakery {
    private String name;
    private int balance;

    private ArrayList<Product> products = new ArrayList<>();

    public Bakery(String name) {
        this.name = name;
        this.balance = 0;

        System.out.println("Bakery " + name + " has been created!");
    }

    public int getBalance() {
        return balance;
    }

    public void addProduct(String name, int bakePrice, int sellPrice) {
        products.add(new Product(name, bakePrice, sellPrice));
    }



}
