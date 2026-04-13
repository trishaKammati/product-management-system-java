import java.sql.*;


public class Main {
    public static void main(String[] args) {

        ProductManager pm=new ProductManager();
       // pm.loadFromFile();
        try {
            pm.addProduct(new Product(1, "Apple"));
            pm.addProduct(new Product(2, "Banana"));
            pm.addProduct(new Product(3, "Orange"));
            pm.addProduct(new Product(4, "Kiwi"));
            pm.addProduct(new Product(5, "Carrot"));
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

        pm.getProduct(2);
        pm.updateProduct(1,"Apple");
        pm.deleteProduct(5);
/*
        System.out.println("---- Initial Products ----");
        pm.showAllProducts();
        try {
            pm.removeProduct(3);
        }catch (ProductNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            pm.updateProduct(5, "Watermelon");
        }catch(ProductNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            pm.getProduct(4);
        }catch (ProductNotFoundException e){
            System.out.println(e.getMessage());
        }
*/
        /*
        try {
            pm.getProduct(10);
        }catch (ProductNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            pm.removeProduct(10);
        }catch (ProductNotFoundException e){
            System.out.println(e.getMessage());
        }

        pm.showAllProducts();

        pm.saveToFile();*/



    }
}