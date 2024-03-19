package com.example.demoSpringWeb.Controller;

import com.example.demoSpringWeb.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demoSpringWeb.Model.Product;

import java.util.List;
@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    Product product;

    @GetMapping("/get-product")
    public Product getProduct() {
        return productService.getProduct(1);
    }

    @GetMapping("/get-products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/create-product")
    public Product createproduct(){
        product.setId(1);
        product.setName("Mobile");
        product.setType("Smartphone");
        product.setCost(76000);
        return productService.createProduct(product);
    }

    @PutMapping("/update-product")
    public Product updateProduct(){
        product.setName("Mobile1");
        product.setType("Smartphone1");
        product.setCost(77000);
        return productService.updateProduct(1,product);
    }

    @DeleteMapping("/delete-product")
    public boolean deleteProduct(){
        return productService.deleteProduct(1);
    }

}
