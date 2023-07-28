import model.Brand;
import model.CellPhone;
import model.Notebook;
import model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Brand> brandList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        // Initialize brand list
        brandList.add(new Brand(1, "Samsung"));
        brandList.add(new Brand(2, "Lenovo"));
        brandList.add(new Brand(3, "Apple"));
        brandList.add(new Brand(4, "Huawei"));
        brandList.add(new Brand(5, "Casper"));
        brandList.add(new Brand(6, "Asus"));
        brandList.add(new Brand(7, "HP"));
        brandList.add(new Brand(8, "Xiaomi"));
        brandList.add(new Brand(9, "Monster"));

        // Adding sample products
        productList.add(new CellPhone(101, 1999.99, 10, 100, "Galaxy S21",
                brandList.get(0), "128 GB", "6.1 Inc", 4000, 6, "Black"));
        productList.add(new Notebook(201, 3499.99, 15, 50, "IdeaPad 5",
                brandList.get(1), 8, "512 SSD", "14 inç"));
        productList.add(new CellPhone(102, 2499.99, 5, 80, "iPhone 12",
                brandList.get(2), "128 GB", "6.1 Inc", 3687, 6, "Red"));

        // Listing all products
        System.out.println("Products in the store:");
        for (Product product : productList) {
            System.out.println(product);
        }

        // Adding a new product
        productList.add(new Notebook(202, 2999.99, 8, 30, "MacBook Air",
                brandList.get(2), 8, "256 SSD", "13.3 inç"));

        // Listing products filtered by brand
        String brandName = "Apple";
        System.out.println("\nProducts filtered by brand: " + brandName);
        for (Product product : productList) {
            if (product.getBrand().getName().equalsIgnoreCase(brandName)) {
                System.out.println(product);
            }
        }

        // Removing a product
        int productIdToRemove = 101;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == productIdToRemove) {
                productList.remove(i);
                System.out.println("\nProduct with ID " + productIdToRemove + " has been removed.");
                break;
            }
        }
    }
}

