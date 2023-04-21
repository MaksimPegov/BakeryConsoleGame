package products;

public abstract class ProductAbstract {
    private String name;
    private int makePrice;
    private int sellPrice;

    public abstract String getName();

    public abstract int getPrice();
}
