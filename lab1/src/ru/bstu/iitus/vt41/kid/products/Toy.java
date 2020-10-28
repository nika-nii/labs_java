package ru.bstu.iitus.vt41.kid.products;

public abstract class Toy extends Product {
    public boolean canBuy(int money){
        return money > getCost();
    };
}