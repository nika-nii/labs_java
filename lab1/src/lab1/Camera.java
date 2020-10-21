package lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

class Camera extends Tech{
    public static String getOutputName(){
        return "Камера";
    };
    public void init(Scanner sc){
        System.out.println("Введите наименование");
        setName(Inputters.getString(sc));
        System.out.println("Введите стоимость");
        setCost(Inputters.getInteger(sc));
    }

    public String toString(){
        return "Камера " + getName() + "\nСтоимость: " + getCost();
    }
}