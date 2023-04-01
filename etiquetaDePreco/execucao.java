package etiquetaDePreco;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class execucao {
    public static void main(String[]args) throws ParseException{
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.print("Number of products:");
        int numberOfProducts = sc.nextInt();
        List<Product> listOfProducts = new ArrayList<Product>();

        for(int i = 0; i < numberOfProducts;i++){
            System.out.println("Product #"+(i+1)+" data:");
            System.out.print("Common,used or imported (c/u/i)?");
            char typeProduct = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name:");
            String name = sc.nextLine();
            System.out.print("Price:");
            Double price = sc.nextDouble();
            

            if(typeProduct == 'c'){
                Product product = new Product(name, price);
                listOfProducts.add(product);
            }
            else if(typeProduct == 'i'){
                System.out.println("Costum Fee:");
                Double costumFee = sc.nextDouble();
                Product product = new ImportedProduct(name, price, costumFee);
                listOfProducts.add(product);
            }
            else if (typeProduct == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String dateStr = sc.next();
                LocalDate date = LocalDate.parse(dateStr, format);
                Product product = new UsedProduct(name, price, date);
                listOfProducts.add(product);
            }

        }
        for(Product product: listOfProducts){
            System.out.println(product.priceTag());
        }


        sc.close();
    }
}
