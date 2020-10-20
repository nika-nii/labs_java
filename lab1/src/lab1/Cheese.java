package lab1;

import java.util.Scanner;

class Cheese extends MilkProduct{
    public void init(Scanner sc){
        System.out.println("Введите наименование");
        setName(Inputters.getString(sc));
        System.out.println("Введите стоимость");
        setCost(Inputters.getInteger(sc));
        System.out.println("Введите вес продукта");
        setWeight(Inputters.getInteger(sc));
    }

    public String toString(){
        return "Сыр " + getName() + "\nСтоимость: " + getCost() + ", вес: " + getWeight();
    }
}