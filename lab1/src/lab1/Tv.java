package lab1;

import java.util.Scanner;

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