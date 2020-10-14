package lab1;

import java.util.*;


public class App {
    static public void printCheapest(ArrayList<Product> products){
        Integer lowestPrice = Integer.MAX_VALUE;
        Integer bestProductIndex = 0;
        for (Integer i = 0; i < products.size(); i++){
            Integer tmp = products.get(i).getCost();
            if (tmp < lowestPrice){
                lowestPrice = tmp;
                bestProductIndex = i;
            }
        }
        System.out.println("Встречайте! Самый дешевый товар - это ...\n" +
                products.get(bestProductIndex).toString());

    }

    static public Product getProduct(Scanner sc){
        Product product = null;

        boolean isCorrectlyInputed = false;
        while (isCorrectlyInputed == false){
            Integer t = sc.nextInt();
            switch (t){
                case 1:
                    product = new RubiksCube();
                    isCorrectlyInputed = true;
                    break;
                case 2:
                    product = new Cheese();
                    isCorrectlyInputed = true;
                    break;
                case 3:
                    product = new Camera();
                    isCorrectlyInputed = true;
                    break;
                case 4:
                    product = new Tv();
                    isCorrectlyInputed = true;
                    break;
                default:
                    System.out.println("Что-то вы не то вводите. Попробуйте еще раз!");

            }
        }
        product.init(sc);
        return product;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<Product>();
        System.out.println("Введите количество товаров:");
        Integer n = sc.nextInt();
        for (Integer i = 0; i < n; i++){
            System.out.println("Введите тип товара (Кубик Рубика - (1), Сыр - (2), Камера - (3), Телевизор - (4)):");
            products.add(getProduct(sc));
        }
        System.out.println("Щас найдем самый дешевый товар!");
        printCheapest(products);
    }
}

