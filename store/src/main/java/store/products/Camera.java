package store.products;

import lombok.ToString;
import store.utils.Inputters;

import java.util.Scanner;

public class Camera extends Tech {
    public void init(Scanner sc) {
        System.out.println("Введите наименование");
        setName(Inputters.getString(sc));
        System.out.println("Введите стоимость");
        setCost(Inputters.getInteger(sc));
    }

    public String toString() {
        return "Камера " + getName() + "\nСтоимость: " + getCost();
    }
}