package com.example.demoSpringWeb.Service;
import com.example.demoSpringWeb.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    Product product = new Product();
    public Product getProduct(int id) {
        return product;
    }

    public List<Product> getProducts(){
        List<Product> newList = new ArrayList<>();
        return newList;
    }

    public Product createProduct(Product product){
        return product;
    }

    public Product updateProduct(int id , Product updatedproduct){
        return new Product();
    }

    public boolean deleteProduct(int id){
        return true;
    }
}
