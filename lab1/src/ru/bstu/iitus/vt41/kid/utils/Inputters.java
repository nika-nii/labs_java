package ru.bstu.iitus.vt41.kid.utils;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Inputters {
    public static String getString(Scanner sc) {
        String result = "";
        boolean isCorrectlyInputted = false;
        while (!isCorrectlyInputted) {
            try {
                sc.nextLine();
                result = sc.nextLine();
                isCorrectlyInputted = true;
            } catch (InputMismatchException ex) {
                System.out.println("Вы как-то не так вводите, прекратите и введите нормально!");
                sc.nextLine();
            }
        }
        return result;
    }

    public static Integer getInteger(Scanner sc) {
        Integer result = 0;
        boolean isCorrectlyInputted = false;
        while (!isCorrectlyInputted) {
            try {
                result = sc.nextInt();
                isCorrectlyInputted = true;
            } catch (InputMismatchException ex) {
                System.out.println("Вы как-то не так вводите, прекратите и введите нормально!");
                sc.nextLine();
            }
        }
        return result;
    }
}
