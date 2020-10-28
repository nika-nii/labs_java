package ru.bstu.iitus.vt41.kid.utils;

import ru.bstu.iitus.vt41.kid.products.*;
import ru.bstu.iitus.vt41.kid.enums.ProductType;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductUtilities {

    static public void printCheapest(ArrayList<Product> products) {
        if (products.size() == 0) {
            throw new IllegalStateException("У вас массив пустой, так нельзя!");
        }
        Product cheapestProduct = products.get(0);
        for (Product p : products) {
            if (p.compareTo(cheapestProduct) == -1) {
                cheapestProduct = p;
            }
        }
        System.out.println("Встречайте! Самый дешевый товар - это ...\n" + cheapestProduct.toString());
    }


    static public Product inputProduct(Scanner sc) {
        System.out.println(String.format("Введите тип товара:\n%s", ProductType.getInputMessage()));
        int type = Inputters.getInteger(sc);
        Product p = null;
        ProductType pt = ProductType.valueof(type);
        boolean isCorrectlyInputted = false;
        while (!isCorrectlyInputted) {
            try {
                p = pt.getProductClass().newInstance();
                p.init(sc);
                isCorrectlyInputted = true;
            } catch (IllegalAccessException | InstantiationException e) {
                isCorrectlyInputted = false;
            }
        }
        return p;
    }
}
