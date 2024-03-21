package com.example.demoSpringWeb.Service;
import com.example.demoSpringWeb.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;

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

























/*
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
    private final List<Product> productList = new ArrayList<>();
    private final Map<Integer, Product> productMap = new HashMap<>();

    public ProductService() {
        Product product1 = new Product(1, "Product1", "Type1", 150000);
        Product product2 = new Product(2, "Product2", "Type2", 20000);
        productList.add(product1);
        productList.add(product2);
        productMap.put(1, product1);
        productMap.put(2, product2);
    }

    public Product getProductById(int id) {
        return productMap.get(id);
    }

    public List<Product> getProducts() {
        return productList;
    }

    public String createProduct(@RequestBody Product newProduct) {
        productList.add(newProduct);
        productMap.put(newProduct.getId(), newProduct);
        return "Product created successfully";
    }

    public String updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        if (productMap.containsKey(id)) {
            productList.remove(productMap.get(id));
            productList.add(updatedProduct);
            productMap.put(id, updatedProduct);
            return "Product updated successfully";
        } else {
            return "Product not found";
        }
    }

    public boolean deleteProduct(int id) {
        if (productMap.containsKey(id)) {
            productList.remove(productMap.get(id));
            productMap.remove(id);
            return true;
        }
        return false;
    }
}


 */