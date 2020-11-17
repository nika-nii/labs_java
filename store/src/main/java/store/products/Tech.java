package store.products;


public abstract class Tech extends Product {
    public boolean canBuy(int money){
        return money > getCost();
    };
}