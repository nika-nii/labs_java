package store;

import store.products.*;
import store.utils.*;

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

