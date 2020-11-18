package store.products;

import java.util.Scanner;

import lombok.ToString;
import store.utils.Inputters;

@ToString(callSuper = true, includeFieldNames=true)
public class RubiksCube extends Toy {
    public void init(Scanner sc) {
        System.out.println("Введите наименование");
        setName(Inputters.getString(sc));
        System.out.println("Введите стоимость");
        setCost(Inputters.getInteger(sc));
    }
}