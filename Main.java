public class Main {
    public static void main(String[] args) {

        ProductManager pm=new ProductManager();

        pm.addProduct(new Product(1,"Apple"));
        pm.addProduct(new Product(2,"Banana"));
        pm.addProduct(new Product(3,"Orange"));
        pm.addProduct(new Product(4,"Kiwi"));
        pm.addProduct(new Product(5,"Carrot"));

        System.out.println("---- Initial Products ----");
        pm.showAllProducts();

        pm.removeProduct(3);

        pm.updateProduct(5,"Watermelon");

        pm.getProduct(4);

        pm.getProduct(10);
        pm.removeProduct(10);

        pm.showAllProducts();

    }
}