package kg.itacademy.hakaton.journal.service;

import kg.itacademy.hakaton.journal.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product newProduct) throws RuntimeException;

    void deleteProduct(Product product) throws RuntimeException;

    Product viewProduct(String productName) throws RuntimeException;

    List<Product> viewAllProducts();
}
