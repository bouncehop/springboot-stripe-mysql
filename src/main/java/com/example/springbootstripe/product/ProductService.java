package com.example.springbootstripe.product;

import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Integer productId) {
        return productRepository.findProductByProductId(productId);
    }

    public void addProduct(Product product) {
        Product productPresent = productRepository.findProductByName(product.getName());
        if (productPresent != null) {
            throw new IllegalStateException("Product already exists");
        }
        productRepository.save(product);
    }

    @Transactional
    public void updateProduct(Integer productId, String name, String description, Long price, Integer stock) {
        Product productToUpdate = productRepository.findProductByProductId(productId);
        if (productToUpdate == null) {
            throw new IllegalStateException("Product does not exist");
        }
        if (name != null && name.length() > 0 && !Objects.equals(name, productToUpdate.getName())) {
            productToUpdate.setName(name);
        }
        if (description != null && description.length() > 0 && !Objects.equals(description, productToUpdate.getDescription())) {
            productToUpdate.setDescription(description);
        }
        if (price != null && price > 0 && !price.equals(productToUpdate.getPrice())) {
            productToUpdate.setPrice(price);
        }
        if (stock != null && stock > 0 && !stock.equals(productToUpdate.getStock())) {
            productToUpdate.setPrice(price);
        }
    }

    @Transactional
    public void deleteProduct(Integer productId) {
//        boolean exists = productRepository.existsByProductId(productId);
//        if (!exists) {
//            throw new IllegalStateException("Product with id " + productId + " does not exist");
//        }
        Product productToDelete = productRepository.findProductByProductId(productId);
        if (productToDelete == null) {
            throw new IllegalStateException("Product does not exist");
        }
        productRepository.deleteByProductId(productId);

    }
}
