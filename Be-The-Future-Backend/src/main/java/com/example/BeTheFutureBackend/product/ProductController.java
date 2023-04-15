package com.example.BeTheFutureBackend.product;

import com.example.BeTheFutureBackend.Customers.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
@CrossOrigin(origins = "*")
public class ProductController {
    private final ProductModel productModel;

    @Autowired
    public ProductController(ProductModel productModel, CustomerModel customerModel) {
        this.productModel = productModel;
    }

    @PostMapping("/add_productByCustomerName/{customerName}")
    public Boolean addProductByCustomerName(@PathVariable("customerName") String customerName, @RequestBody Product product) {
        return productModel.addProductByCustomerName(customerName, product);
    }

    @GetMapping("/getAllProducts")
    public Iterable<Product> getAllProducts() {
        return productModel.getAllProducts();
    }

    @GetMapping("/getProductBycustomerName/{customerName}")
    public Iterable<Product> getProductBycustomerName(@PathVariable("customerName") String customerName) {
        return productModel.getProductBycustomerName(customerName);
    }

    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productModel.getProduct(id).get();
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productModel.deleteProduct(id);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return productModel.updateProduct(product);
    }
    //update product state to inprogress
    @PutMapping("/acceptProduct/{id}")
    public Product updateProductState(@PathVariable("id") Long id) {
        return productModel.updateProductState(id);

    }

    @PutMapping("/updateProductStatus/{id}")
    public Product updateProductStatus(@PathVariable("id") Long id) {
        return productModel.updateProductStatus(id);

    }
}
