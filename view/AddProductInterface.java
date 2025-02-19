package view;

import controller.ProductController;
import model.Product;

import java.math.BigDecimal;
import java.util.Scanner;

public class AddProductInterface {

    public static void addProduct() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Product's name: ");
        String name = sc.nextLine();
        System.out.println("Product's price: ");
        BigDecimal price = sc.nextBigDecimal();
        sc.nextLine();
        System.out.println("Product's quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.println("Product's category Id: ");
        int categoryId = sc.nextInt();
        sc.nextLine();

        Product p = new Product(name, price, quantity, categoryId);
        ProductController.addProduct(p);
        sc.close();

    }
}
