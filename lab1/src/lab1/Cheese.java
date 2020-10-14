package lab1;

import java.util.Scanner;

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