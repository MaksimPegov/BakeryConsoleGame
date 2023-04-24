package products;

public abstract class ProductAbstract {
    private final String name;
    private final double makePrice;
    private final double sellPrice;

    public ProductAbstract(String name, double makePrice, double sellPrice) {
        this.name = name;
        this.makePrice = makePrice;
        this.sellPrice = sellPrice;
    }

    public String getName(){
        return this.name;
    }

    public double getSellPrice(){
        return sellPrice;
    }

    public double getMakePrice(){
        return makePrice;
    }
}
