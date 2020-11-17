package store.products;

import java.util.Scanner;

import store.utils.Inputters;

public class RubiksCube extends Toy {
    public void init(Scanner sc) {
        System.out.println("Введите наименование");
        setName(Inputters.getString(sc));
        System.out.println("Введите стоимость");
        setCost(Inputters.getInteger(sc));
    }

    public String toString() {
        return "Кубик Рубика " + this.getName() + "\nСтоимость: " + getCost();
    }
}