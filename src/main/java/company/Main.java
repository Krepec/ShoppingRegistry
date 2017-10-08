package company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by laptop on 29.09.17.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        boolean endShopping = true;
        ShoppingRegistry shoppingRegistry = new ShoppingRegistry();
        while (endShopping) {

            Scanner input = new Scanner(System.in);  //unrechable statment - nie wykona tego założenia
            System.out.println("Podaj nazwę produktu: ");
            String name = input.nextLine();
            System.out.println("Podaj cenę produktu: ");

            boolean chatchException = true;

            while (chatchException == true) {
                try {
                    String price = input.nextLine();
                    Double.valueOf(price);
                    shoppingRegistry.addData(name, price);

                } catch (Exception e) {

                    System.out.println("Wprowadz cenę prodyktu !!!");
                }
            }
            System.out.println("Czy chcesz zakończyć zakupy wciśnij 1: ");
            int end = input.nextInt();

            if (end == 1){
                endShopping = false;
            }


        }
        System.out.println("całkowity koszt: " + shoppingRegistry.totalPrice());
    }
}

//WRZUCIĆ NA GITA !!!