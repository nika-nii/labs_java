package store.products;

public abstract class Toy extends Product {
    public boolean canBuy(int money){
        return money > getCost();
    };
}