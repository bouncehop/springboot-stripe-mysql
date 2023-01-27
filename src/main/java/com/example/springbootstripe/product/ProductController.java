package com.example.springbootstripe.product;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public String getProduct(@PathVariable("productId") Integer productId) {
        return new Gson().toJson(productService.getProduct(productId));
    }

    @PostMapping("/add")
    public void addNewProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("update/{productId}")
    public void updateUser(@PathVariable("productId") Integer productId,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String description,
                           @RequestParam(required = false) Long price,
                           @RequestParam(required = false) Integer stock) {
        productService.updateProduct(productId, name, description, price, stock);
    }

    @DeleteMapping("/delete/{productId}")
    public void deleteUser(@PathVariable("productId") Integer productId) {
        productService.deleteProduct(productId);
    }

}
