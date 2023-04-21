package products;

public abstract class ProductAbstract {
    private final String name;
    private final int makePrice;
    private final int sellPrice;

    public ProductAbstract(String name, int makePrice, int sellPrice) {
        this.name = name;
        this.makePrice = makePrice;
        this.sellPrice = sellPrice;
    }

    public String getName(){
        return this.name;
    }

    public int getSellPrice(){
        return sellPrice;
    }

    public int getMakePrice(){
        return makePrice;
    }
}
