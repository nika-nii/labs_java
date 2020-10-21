package lab1;

import lab1.products.Product;

import java.util.*;

public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<Product>();
        System.out.println("Введите количество товаров:");
        Integer n = sc.nextInt();
        for (Integer i = 0; i < n; i++){
            products.add(ProductUtilities.getProduct(sc));
        }
        System.out.println("Щас найдем самый дешевый товар!");
        ProductUtilities.printCheapest(products);
    }
}

