package ru.bstu.iitus.vt41.kid.products;


public abstract class MilkProduct extends Product {
    private Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer newWeight) {
        weight = newWeight;
    }

    public boolean canBuy(int money) {
        return money > getCost() * getWeight();
    }
}