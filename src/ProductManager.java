import jdk.jshell.spi.SPIResolutionException;

import java.sql.*;
import java.io.*;

public class ProductManager {

    /*Map<Integer,Product> productMap;
    public ProductManager(){
        productMap=new HashMap<>();
    }

    public void addProduct(Product product) throws DuplicateProductException{
        if(productMap.containsKey(product.getId())){
            throw new DuplicateProductException("Product with this id already Exists");
        }

        productMap.put(product.getId(), product);


    }

    public void showAllProducts(){
        System.out.println("List of the Products: ");
        /*for(Map.Entry<Integer,Product> entry: productMap.entrySet()){
            Product p=entry.getValue();
            System.out.println(entry.getKey()+"->"+p.getName());
        }*/
      /*  for(Product p:productMap.values()){
            System.out.println(p);
        }
    }

    public void removeProduct(int id) throws ProductNotFoundException{
        if(productMap.containsKey(id)){
            productMap.remove(id);
            System.out.println("Product removed successfully");
        }
        else {
            throw new ProductNotFoundException("Product doesn't exists");
        }
    }

    public void getProduct(int id) throws ProductNotFoundException{
        if(productMap.containsKey(id)){
            Product p=productMap.get(id);
            System.out.println(p.getId()+" -> "+p.getName());
        }
        else
        {
           throw new ProductNotFoundException("Product doesn't exists");
        }
    }

    public void updateProduct(int id,String newName) throws ProductNotFoundException{
        if(productMap.containsKey(id)){
            Product p=productMap.get(id);
            p.setName(newName);
            System.out.println("Product Updated Successfully");
        }
        else
        {
            throw new ProductNotFoundException("Product doesn't exists");
        }
    }

    public void saveToFile(){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("Products.txt"))) {

            for(Product p: productMap.values()) {
                writer.write(p.getId() + "," + p.getName());
                writer.newLine();
            }

        } catch (IOException e){
            System.out.println("Error Saving File:"+e.getMessage());
        }
    }

    public void loadFromFile(){
        try(BufferedReader reader=new BufferedReader(new FileReader("Products.txt"))){
            String line;
            while((line=reader.readLine())!=null){
                String[] parts=line.split(",");
                int id= Integer.parseInt(parts[0]);
                Product p=new Product(id,parts[1]);
                productMap.put(id,p);
            }
        } catch (IOException e){
            System.out.println("Error Reading File:"+e.getMessage());
        }
    }*/


    // JDBC: Connecting to SQL
    Connection con;
    public ProductManager() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/product_db",
                    "root",
                    "root"
            );
        } catch (SQLException e) {
            System.out.println("Connection Error");
        }
    }
    public void addProduct(Product product) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO products VALUES(?,?)");

            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());

            ps.executeUpdate();
            System.out.println("Product Added");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getProduct(int id){
        try{
            PreparedStatement ps=con.prepareStatement("SELECT * FROM products WHERE id=?");
            ps.setInt(1,id);

            ResultSet rs=ps.executeQuery();

            if(rs.next()) {
                System.out.println(rs.getInt("id")+" -> "+rs.getString("name"));
            } else {
                System.out.println("Product not found");
            }
        } catch (SQLException e){
            System.out.println("Product not found");
        }
    }

    public void updateProduct(int id,String newName){
        try{
            PreparedStatement ps=con.prepareStatement("UPDATE products SET name=? WHERE id=?");
            ps.setString(1,newName);
            ps.setInt(2,id);

            int rows= ps.executeUpdate();

            if(rows>0){
                System.out.println("Product Updated");
            }
            else {
                System.out.println("Product Not Updated");
            }

        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void deleteProduct(int id){
        try{
            PreparedStatement ps= con.prepareStatement("DELETE FROM products WHERE id=?");
            ps.setInt(1,id);
            int rows=ps.executeUpdate();
            if(rows>0){
            System.out.println("Product Deleted");}
            else{
                System.out.println("Product not deleted ");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
