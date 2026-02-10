package com.example.main;

import com.example.dao.ProductDao;
import com.example.entity.Product;

public class MainApp {

    public static void main(String[] args) {

        ProductDao dao = new ProductDao();

        // INSERT
        Product p1 = new Product("Laptop", "Gaming Laptop", 75000, 10);
        Product p2 = new Product("Mouse", "Wireless Mouse", 1500, 50);

        dao.saveProduct(p1);
        dao.saveProduct(p2);

        // READ
        Product product = dao.getProductById(1);
        System.out.println("Product Name: " + product.getName());

        // UPDATE
        product.setPrice(72000);
        product.setQuantity(8);
        dao.updateProduct(product);

        // DELETE
        dao.deleteProduct(2);
    }
}
