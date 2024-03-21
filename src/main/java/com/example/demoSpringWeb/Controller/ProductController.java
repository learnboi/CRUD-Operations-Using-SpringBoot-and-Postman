package com.example.demoSpringWeb.Controller;

import com.example.demoSpringWeb.Model.Product;
import com.example.demoSpringWeb.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {

    final
    ProductService productService;
    final
    Product product;

    public ProductController(ProductService productService, Product product) {
        this.productService = productService;
        this.product = product;
    }

    @GetMapping("/get-product/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/get-products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/create-product")
    public String createProduct(@RequestBody Product newProduct){
        return productService.createProduct(newProduct);
    }

    @PutMapping("/update-product/{id}")
    public String updateProduct(@PathVariable int id,@RequestBody Product updateProduct){
        return productService.updateProduct(id,updateProduct);
    }

    @DeleteMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }

}
