package controller;

import DAO.ProductDao;
import model.Product;

public class ProductController {
    public static void addProduct(Product product) {

        try {
            ProductDao.addDao(product);
            System.out.println(product.getName() + " adicionado(a) com ID: " + product.getId());
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto " + e.getMessage());
        }
    }

    public static void updateNameProduct(String name, int id){
        try{
            ProductDao.attNameDao(name, id);
            System.out.println("Nome modificado com sucesso!");
        } catch (Exception e){
            System.out.println("Erro ao tentar modificar o produto " + e.getMessage());
        }
    }

    public static void deleteProduct(int id){
        try{
            ProductDao.deleteDao(id);
            System.out.println("Produto removido Com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao deletar o produto " + e.getMessage());
        }

    }
}
