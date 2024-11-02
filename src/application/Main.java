package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("Product #" + (i+1) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            String choice = sc.next();

            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            if(choice.equals("c")){
                list.add(new Product(name, price));
            }
            else if (choice.equals("u")){

                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(sc.next());
                list.add(new UsedProduct(name, price, manufactureDate));
            }
            else if(choice.equals("i")){

                System.out.print("Custom Fee: ");
                double customFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customFee));
            }
            else {

                System.out.println("Enter a valid option!");
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");

        for(Product c: list){
            System.out.println(c.priceTag());
        }
        sc.close();

    }
}