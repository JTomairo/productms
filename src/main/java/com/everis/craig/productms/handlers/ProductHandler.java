package com.everis.craig.productms.handlers;

import com.everis.craig.productms.dao.ProductDao;
import com.everis.craig.productms.documents.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class ProductHandler {

    @Autowired
    private ProductDao productDao;

    private static final Logger logger = LoggerFactory.getLogger(ProductHandler.class);

    @GetMapping("/list")
    public Flux<?> findAll() {
        logger.info("Find all clients");
        return productDao.findAll();
    }

    @GetMapping("/list/{id}")
    public Mono<?> findById(@PathVariable("id") String id) {
        logger.info("Find by Id: {}", id);
        return productDao.findById(id);
    }

    @PostMapping("/create/product")
    public void createProduct(@RequestBody Product product) {
        productDao.save(product).subscribe();
    }

    @PutMapping("/update/product")
    public Mono<Product> updateProduct(@RequestBody Product product) {
        return productDao.save(product);
    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<Product>> updateTweet(@PathVariable(value = "id") String id,
                                                     @RequestBody Product product) {
        return productDao.findById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setProductName(product.getProductName());
                    return productDao.save(existingProduct);
                })
                .map(updateProduct -> new ResponseEntity<>(updateProduct, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") String id) {
        productDao.deleteById(id).subscribe();
    }

}
