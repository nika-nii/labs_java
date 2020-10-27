package ru.bstu.iitus.vt41.kid.products;
import java.util.Scanner;

public abstract class Product implements Comparable<Product>{
    private String name;
    private Integer cost;
    public void setName(String newName){ this.name = newName; }
    public void setCost(Integer newCost){ this.cost = newCost; }
    public String getName(){ return name; }
    public Integer getCost(){ return cost; }

    public static String getOutputName(){
        return "НИ-ЧЕ-ГО";
    };

    public abstract void init(Scanner scanner); // считывание параметров с консоли
    public abstract boolean canBuy(int money);  // определяет, можно ли купить товар за имеющуюся сумму
    public abstract String toString();          // возвращается состояние объекта в виде строки (определяется только в наследниках, т.к. определен в // Object)

    public int compareTo(Product p) {
        Integer cost1 = this.getCost();
        Integer cost2 = p.getCost();
        if (cost1 == cost2) return 0;
        if (cost1 > cost2)
            return 1;
        return -1;
    }
}