package lab1;
import java.util.Scanner;

abstract class Product {
    private String name;
    private Integer cost;
    public void setName(String newName){ name = newName; }
    public void setCost(Integer newCost){ cost = newCost; }
    public String getName(){ return name; }
    public Integer getCost(){ return cost; }

    public abstract void init(Scanner scanner); // считывание параметров с консоли
    public abstract boolean canBuy(int money);   // определяет, можно ли купить товар за имеющуюся сумму
    public abstract String toString();          // возвращается состояние объекта в виде строки (определяется только в наследниках, т.к. определен в // Object)
}