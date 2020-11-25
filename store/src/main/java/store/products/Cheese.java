package store.products;

import lombok.ToString;
import store.utils.Inputters;

import java.util.Scanner;

@ToString(callSuper = true, includeFieldNames = true)
public class Cheese extends MilkProduct {
    public void init(Scanner sc) {
        System.out.println("Введите наименование");
        setName(Inputters.getString(sc));
        System.out.println("Введите стоимость");
        setCost(Inputters.getInteger(sc));
        System.out.println("Введите вес продукта");
        setWeight(Inputters.getInteger(sc));
    }
}