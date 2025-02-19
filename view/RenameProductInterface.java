package view;

import controller.ProductController;

import java.util.Scanner;

public class RenameProductInterface {

    public static void changeProductName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("New name: ");
        String newName = sc.nextLine();
        System.out.println("Original id: ");
        int originalId = sc.nextInt();
        ProductController.updateNameProduct(newName, originalId);
    }
}
