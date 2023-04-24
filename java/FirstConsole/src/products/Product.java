package products;

public class Product extends ProductAbstract{
    private int amount;

    public Product(String name, double makePrice, double sellPrice) {
        super(name, makePrice, sellPrice);
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return this.amount;
    }

    public void increase(){
        this.amount ++;
    }

    public void decrease(){
        this.amount --;
    }
}
