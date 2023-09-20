package kg.itacademy.hakaton.journal.service.impl;

import kg.itacademy.hakaton.journal.entity.Product;
import kg.itacademy.hakaton.journal.repository.ProductRepository;
import kg.itacademy.hakaton.journal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product newProduct) throws RuntimeException {
        Optional<Product> existProduct = productRepository.findByName(newProduct.getName_of_product());

        if(existProduct.isEmpty()) {
            throw new RuntimeException("Product is already exists");
        }
        productRepository.save(newProduct);
        return newProduct;
    }

    @Override
    public void deleteProduct(Product product) throws RuntimeException {
        Optional<Product> existProduct = productRepository.findByName(product.getName_of_product());

        if(existProduct.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(product.getId_of_product());
    }

    @Override
    public Product viewProduct(String productName) throws RuntimeException {
        Optional<Product> existProduct = Optional.ofNullable(productRepository.findByName(productName).orElseThrow(() -> new RuntimeException("Product not found!")));

        return existProduct.get();
    }

    @Override
    public List<Product> viewAllProducts() {
        List<Product> products = productRepository.findAll();

        if(products.isEmpty()) {
            throw new RuntimeException("Product list is empty");
        }
        return products;
    }



}
