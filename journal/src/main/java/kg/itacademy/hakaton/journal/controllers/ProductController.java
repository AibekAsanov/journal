package kg.itacademy.hakaton.journal.controllers;

import kg.itacademy.hakaton.journal.entity.Product;
import kg.itacademy.hakaton.journal.repository.ProductRepository;
import kg.itacademy.hakaton.journal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public String creatingForm() {
        return "/creatingForm";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {
        productService.createProduct(product);
        return "product";
    }


}
