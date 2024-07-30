import java.util.Arrays;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
               "productId='" + productId + '\'' +
               ", productName='" + productName + '\'' +
               ", category='" + category + '\'' +
               '}';
    }
}

public class Exercise2 {

    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Book", "Literature"),
            new Product("P004", "Headphones", "Accessories"),
            new Product("P005", "Keyboard", "Accessories")
        };
//Linaer Search
        Product foundProduct = linearSearch(products, "P003");
        if (foundProduct != null) {
            System.out.println("Linear Search: Found " + foundProduct);
        } else {
            System.out.println("Linear Search: Product not found");
        }

        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));
//Binary Search
        foundProduct = binarySearch(products, "P002");
        if (foundProduct != null) {
            System.out.println("Binary Search: Found " + foundProduct);
        } else {
            System.out.println("Binary Search: Product not found");
        }
    }

    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product.getProductId().equals(targetId)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = products[mid];
            int comparison = midProduct.getProductId().compareTo(targetId);

            if (comparison == 0) {
                return midProduct; 
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; 
    }
}
