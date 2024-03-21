package com.example.demoSpringWeb.Service;
import com.example.demoSpringWeb.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    List<Product> newList = new ArrayList<>();
    public ProductService(){
        Product product = new Product(1,"Product1","Type1",150000);
        Product product1 = new Product(2,"Product2","Type2",20000);
        newList.add(product);
        newList.add(product1);
    }

    public Product getProductById(int id) {
        for (Product p : newList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }


    public List<Product> getProducts(){
        return newList;
    }

    public String createProduct(@RequestBody Product newProduct){
        for(Product p : newList){
            if(p.getId() == newProduct.getId()){
                return "Id already exists";
            }
        }
        newList.add(newProduct);
        return "Product created successfully";
    }

    public String updateProduct(@PathVariable int id, @RequestBody Product updateProduct){
        for(Product p : newList){
            if(p.getId() == id){
                newList.remove(p);
                newList.add(updateProduct);
            }
        }
        return "Product Updated Successfully";
    }

    public String deleteProduct(int id){
        for (Product p : newList) {
            if (p.getId() == id) {
                newList.remove(p);
                return "Product Removed Successfully";
            }
        }
        return "Product not found";
    }
}
