package view;

import controller.ProductController;

import java.util.Scanner;

public class DeleteProductInterface {

    public static void deleteProduct(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Product's id to be removed: ");
        int removeProduct = sc.nextInt();
        ProductController.deleteProduct(removeProduct);
    }
}
