import java.util.*;
import java.io.*;

public class ProductManager {

    Map<Integer,Product> productMap;
    public ProductManager(){
        productMap=new HashMap<>();
    }
    public void addProduct(Product product) throws DuplicateProductException{
        if(productMap.containsKey(product.getId())){
            throw new DuplicateProductException("Product with this Id already Exists");
        }

        productMap.put(product.getId(), product);

    }

    public void showAllProducts(){
        System.out.println("List of the Products: ");
        /*for(Map.Entry<Integer,Product> entry: productMap.entrySet()){
            Product p=entry.getValue();
            System.out.println(entry.getKey()+"->"+p.getName());
        }*/
        for(Product p:productMap.values()){
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
    }


}
