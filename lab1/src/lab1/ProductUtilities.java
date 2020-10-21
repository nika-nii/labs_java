package lab1;

import lab1.products.*;

import java.util.ArrayList;

import java.util.Scanner;

public class ProductUtilities {

    static public void printCheapest(ArrayList<Product> products){
        if (products.size() == 0){
            System.out.println("У вас массив пустой, так нельзя!");
            return;
        }
        Product cheapestProduct = products.get(0);
        for (Product p : products){
            if (p.compareTo(cheapestProduct) == -1){
                cheapestProduct = p;
            }
        }
        System.out.println("Встречайте! Самый дешевый товар - это ...\n" + cheapestProduct.toString());
    }



    static public Product getProduct(Scanner sc){
        String inputTypes = RubiksCube.getOutputName();
        System.out.println(String.format("Введите тип товара (%s)", inputTypes));

        Product product = null;
        boolean isCorrectlyInputted = false;
        while (isCorrectlyInputted == false){
            Integer t = Inputters.getInteger(sc);
            switch (t) {
                case 1:
                    product = new RubiksCube();
                    isCorrectlyInputted = true;
                    break;
                case 2:
                    product = new Cheese();
                    isCorrectlyInputted = true;
                    break;
                case 3:
                    product = new Camera();
                    isCorrectlyInputted = true;
                    break;
                case 4:
                    product = new Tv();
                    isCorrectlyInputted = true;
                    break;
                default:
                    System.out.println("Нет такого продукта!");
            }
        }
        product.init(sc);
        return product;
    }
}
