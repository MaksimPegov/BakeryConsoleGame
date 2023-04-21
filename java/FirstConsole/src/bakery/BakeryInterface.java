package bakery;

public interface BakeryInterface {
    void addProduct(String name, int bakePrice, int sellPrice);
    void listProducts();
    void removeProduct(String name);
    void bakeProduct(String name);
    void sellProduct(String name);
}
