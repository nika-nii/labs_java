package store.utils;

import lombok.experimental.UtilityClass;
import store.enums.ProductType;
import store.products.Product;

import java.util.ArrayList;
import java.util.Scanner;

@UtilityClass
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


    static public Product inputProduct(Scanner sc) throws InputException {
        System.out.println(String.format("Введите тип товара:\n%s", ProductType.getInputMessage()));

        Product p = null;
        ProductType pt = null;
        while (pt == null) {
            try {
                pt = ProductType.val(Inputters.getInteger(sc));
            } catch (InputException ex) {
                System.out.println(ex + " Повторите ввод.");
            }
        }

        try {
            p = pt.getProductClass().newInstance();
            p.init(sc);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new InputException("Произошла ошибка при инициализации продукта");
        }

        return p;
    }
}
