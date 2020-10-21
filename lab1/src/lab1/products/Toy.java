package lab1.products;

public abstract class Toy extends Product {
    public boolean canBuy(int money){
        if (money > getCost()){
            return true;
        }
        return false;
    };
}