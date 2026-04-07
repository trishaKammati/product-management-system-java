import java.util.*;

public class ProductManager {

    Map<Integer,Product> productMap;
    public ProductManager(){
        productMap=new HashMap<>();
    }
    public void addProduct(Product product){
        if(productMap.containsKey(product.getId())){
            System.out.println("Id already exists");
        }
        else {
            productMap.put(product.getId(), product);
        }
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

    public void removeProduct(int id){
        if(productMap.containsKey(id)){
            productMap.remove(id);
            System.out.println("Product removed successfully");
        }
        else {
            System.out.println("Product Not Found");
        }
    }

    public void getProduct(int id){
        if(productMap.containsKey(id)){
            Product p=productMap.get(id);
            System.out.println(p.getId()+" -> "+p.getName());
        }
        else
        {
            System.out.println("Product Not Found");
        }
    }

    public void updateProduct(int id,String newName){
        if(productMap.containsKey(id)){
            Product p=productMap.get(id);
            p.setName(newName);
            System.out.println("Product Updated Successfully");
        }
        else
        {
            System.out.println("Product Not Found");
        }
    }


}
