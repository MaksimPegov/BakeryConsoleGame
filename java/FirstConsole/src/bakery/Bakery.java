package bakery;

import products.Product;

import java.util.ArrayList;

public class Bakery implements BakeryInterface {
    private final String name;
    private int balance;

    private ArrayList<Product> products;

    public Bakery(String name, int balance) {
        this.name = name;
        this.balance = balance;

        products = new ArrayList<>();

        System.out.println("Bakery " + name + " has been created!");
    }

    public int getBalance() {
        return balance;
    }

    public String addProduct(String name, int bakePrice, int sellPrice) {
        products.add(new Product(name, bakePrice, sellPrice));
        return name + " has been added!";
    }

    @Override
    public ArrayList<Product> listProducts() {
        return products;
    }

    @Override
    public String removeProduct(String name) {
        try{
            products.remove(name);
            return name + " has been removed!";
        }catch (Exception e){
            return "No such product!";
        }
    }

    @Override
    public String bakeProduct(String name, int amount) {
        try {
            boolean found = false;
            int index = -1;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getName().equals(name)) {
                    found = true;
                    index = i;
                    break;
                }
            }
            if (products.get(index).getMakePrice() * amount > balance) {
                return "Not enough money(";
            }
            for (int i = 0; i < amount; i++) {
                balance -= products.get(index).getMakePrice();
                products.get(index).increase();
            }
            return amount + name + " has been baked!";

        } catch (Exception e) {
            return "No such product!";
        }
    }

    @Override
    public String sellProduct(String name, int amount) {
        if (amount < 0) {
            return "Invalid amount!";
        }

        try {
            boolean found = false;
            int index = -1;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getName().equals(name)) {
                    found = true;
                    index = i;
                    break;
                }
            }
            if (products.get(index).getAmount() < amount) {
                return "Not enough products!";
            }
            for (int i = 0; i < amount; i++) {
                balance += products.get(index).getSellPrice();
                products.get(index).decrease();
            }
            return amount + name + " has been sold!";
        } catch (Exception e) {
            return "No such product!";
        }
    }

}
