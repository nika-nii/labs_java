package ru.bstu.iitus.vt41.kid.products;


public abstract class Tech extends Product {
    public boolean canBuy(int money){
        return money > getCost();
    };
}