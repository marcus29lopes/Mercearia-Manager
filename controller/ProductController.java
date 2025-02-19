package controller;

import DAO.ProductDao;
import model.Product;

public class ProductController {
    public static void addProductController(Product product){

        try{
            ProductDao.insertProduct(product);
            System.out.println("Produto adicionado com sucesso");
        } catch (Exception e){
            System.out.println("Erro ao cadastrar produto " + e.getMessage());
        }


    }
}
