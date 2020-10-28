package ru.bstu.iitus.vt41.kid;

import ru.bstu.iitus.vt41.kid.products.*;
import ru.bstu.iitus.vt41.kid.utils.*;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        System.out.println("Введите количество товаров:");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            products.add(ProductUtilities.inputProduct(sc));
        }
        System.out.println("Щас найдем самый дешевый товар!");
        ProductUtilities.printCheapest(products);
    }
}

