package lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductUtilities {
    private static ArrayList<Class> classTypes = new ArrayList<Class>(){
        {
            System.out.println("!!!!!!");
            classTypes.add(1, RubiksCube.class);
            classTypes.add(2, Cheese.class);
            classTypes.add(3, Camera.class);
            classTypes.add(4, Tv.class);
            System.out.println("!!!!!!");
        }
    };
    private static String outputNames = String.format(new String("%i: %s, %i: %s, %i: %s, %i: %s"),
            1, RubiksCube.getOutputName(),
            2, Cheese.getOutputName(),
            3, Camera.getOutputName(),
            4, Tv.getOutputName());

    public static init(){

    }
    
    public static void printCheapest(ArrayList<Product> products){
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



    public static Product getProduct(Scanner sc){
        //System.out.println(String.format( "Введите тип товара: %s", outputNames));



        Product product = null;
        boolean isCorrectlyInputted = false;
        while (!isCorrectlyInputted){
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
