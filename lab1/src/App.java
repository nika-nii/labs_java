package lab1;

import javax.sound.midi.SysexMessage;
import java.util.*;

/*Создать абстрактный класс Product с методами:
public abstract void init(Scanner scanner)  // считывание параметров с консоли
public abstract int getCost()               // возвращает стоимость товара
public abstract boolean canBuy(int cost);   // определяет, можно ли купить товар за имеющуюся сумму
public String toString()                    // возвращается состояние объекта в виде строки (определяется только в наследниках, т.к. определен в // Object)
        Построить иерархию классов:
        Товар   → Игрушка   → Кубик-рубик
                → Молочный  → Сыр
                → Техника   → Камера
                            → Телевизор

*/
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

abstract class Toy extends Product{
    public boolean canBuy(int money){
        if (money > getCost()){
            return true;
        }
        return false;
    };
}

abstract class MilkProduct extends Product{
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

abstract class Tech extends Product {
    public boolean canBuy(int money){
        if (money > getCost()){
            return true;
        }
        return false;
    };
}

class RubiksCube extends Toy{
    public void init(Scanner scanner){
        System.out.println("Введите наименование");
        setName(scanner.next());
        System.out.println("Введите стоимость");
        setCost(scanner.nextInt());
    }

    public String toString(){
        return "Кубик Рубика " + getName() + "\nСтоимость: " + getCost();
    }
}

class Cheese extends MilkProduct{
    public void init(Scanner scanner){
        System.out.println("Введите наименование");
        setName(scanner.next());
        System.out.println("Введите стоимость");
        setCost(scanner.nextInt());
        System.out.println("Введите вес продукта");
        setWeight(scanner.nextInt());
    }

    public String toString(){
        return "Сыр " + getName() + "\nСтоимость: " + getCost() + ", вес: " + getWeight();
    }
}

class Camera extends Tech{
    public void init(Scanner scanner){
        System.out.println("Введите наименование");
        setName(scanner.next());
        System.out.println("Введите стоимость");
        setCost(scanner.nextInt());
    }

    public String toString(){
        return "Камера " + getName() + "\nСтоимость: " + getCost();
    }
}

class Tv extends Tech{
    public void init(Scanner scanner){
        System.out.println("Введите наименование");
        setName(scanner.next());
        System.out.println("Введите стоимость");
        setCost(scanner.nextInt());
    }

    public String toString(){
        return "Телевизор" + getName() + "\nСтоимость: " + getCost();
    }
}
    /*Написать программу, которая:
        1) Считывает с консоли количество товаров.
        2) В цикле считывает параметры. Сначала спрашивается вид товара и создается объект
        нужного класса. Затем у объекта вызывается метод init() и вводятся характеристики
        объекта (стоимость, наименование игрушки, разрешение камеры, размер диагонали
        телевизора и т.д.).
        Метод init() разный у разных классов.
        3) Считанные объекты кладутся в массив
        4) Ищется самый дешевый товар и выводится на экран (вывод через toString())*/
public class App {
    static public void printCheapest(ArrayList<Product> products){
        Integer lowestPrice = Integer.MAX_VALUE;
        Integer bestProductIndex = 0;
        for (Integer i = 0; i < products.size(); i++){
            Integer tmp = products.get(i).getCost();
            if (tmp < lowestPrice){
                lowestPrice = tmp;
                bestProductIndex = i;
            }
        }
        System.out.println("Встречайте! Самый дешевый товар - это ...\n" +
                products.get(bestProductIndex).toString());

    }

    static public Product getProduct(Scanner sc){
        Product product = null;
        Integer t = sc.nextInt();
        boolean isCorrectlyInputed = false;
        while (isCorrectlyInputed == false)
        switch (t){
            case 1:
                product = new RubiksCube();
                isCorrectlyInputed = true;
                break;
            case 2:
                product = new Cheese();
                isCorrectlyInputed = true;
                break;
            case 3:
                product = new Camera();
                isCorrectlyInputed = true;
                break;
            case 4:
                product = new Tv();
                isCorrectlyInputed = true;
                break;
            default:
                System.out.println("Что-то вы не то вводите. Попробуйте еще раз!");

        }
        product.init(sc);
        return product;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<Product>();
        System.out.println("Введите количество товаров:");
        Integer n = sc.nextInt();
        for (Integer i = 0; i < n; i++){
            System.out.println("Введите тип товара (Кубик Рубика - (1), Сыр - (2), Камера - (3), Телевизор - (4)):");
            products.add(getProduct(sc));
        }
        System.out.println("Щас найдем самый дешевый товар!");
        printCheapest(products);


    }
}

