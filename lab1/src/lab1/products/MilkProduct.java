package lab1.products;

import lab1.products.Product;

public abstract class MilkProduct extends Product {
    private Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer newWeight){
        weight = newWeight;
    }

    public boolean canBuy(int money){
        if (money > getCost() * getWeight()){
            return true;
        }
        return false;
    };
}