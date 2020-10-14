package lab1;

import java.util.Scanner;

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