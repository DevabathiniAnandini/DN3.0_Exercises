import java.util.HashMap;

class Product{
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName,int quantity,double price)
    {
        this.productId=productId;
        this.productName=productName;
        this.quantity=quantity;
        this.price=price;
    }

    public String getProductId()
    {
        return productId;
    }
    public void setProductId(String productId)
    {
        this.productId=productId;
    }
    public String getProductName()
    {
        return productName;
    }
    public void setProductName(String productName)
    {
        this.productName=productName;
    }
    public int getQuanity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }

    public String toString(){
        return "Product {"+
        "product Id=" +productId+", "+"product Name=" +productName + ", "+"Quantity="+quantity+", "+"Price="+price+" }";
    }
}

class Inventory{
    private HashMap<String, Product> productInventory;
    
    public Inventory(){
        productInventory=new HashMap<>();
    } 

    public void addProduct(Product product)
    {
        productInventory.put(product.getProductId(),product);
        System.out.println("Product added: "+product);
    }

    public void updateProduct(String productId,Product updatedProduct){
        if (productInventory.containsKey(productId)) {
            productInventory.put(productId, updatedProduct);
            System.out.println("Product updated: " + updatedProduct);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void deleteProduct(String productId) {
        Product removedProduct = productInventory.remove(productId);
        if (removedProduct != null) {
            System.out.println("Product removed: " + removedProduct);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void displayProducts() {
        for (Product product : productInventory.values()) {
            System.out.println(product);
        }
    }



}

public class IMS{
    public static void main(String args[])
    {
        Inventory inv=new Inventory();
        Product p1=new Product("P001","Laptop",10,999.99);
        Product p2=new Product("P002","Mobile",20,599.99);
        System.out.println();
        inv.addProduct(p1);
        inv.addProduct(p2);
        System.out.println();

        inv.displayProducts();

        Product update=new Product("P002","Mobile",15,579.99);
        inv.updateProduct("P002",update);
        System.out.println();
        inv.displayProducts();

        inv.deleteProduct("P001");
        System.out.println();
        inv.displayProducts();
    }
}












