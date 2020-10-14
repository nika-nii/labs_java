package lab1;

import java.util.Scanner;

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