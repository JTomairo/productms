package com.everis.craig.productms.handlers;

import com.everis.craig.productms.documents.Product;
import com.everis.craig.productms.service.impl.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductHandler {


    @Autowired
    private ProductServiceImpl productService;

    private static final Logger logger = LoggerFactory.getLogger(ProductHandler.class);

    @GetMapping("/list")
    public Flux<?> findAll() {
        logger.info("Find all clients");
        return productService.findAll();
    }

    @GetMapping("/list/{id}")
    public Mono<?> findById(@PathVariable("id") String id) {
        logger.info("Find by Id: {}", id);
        return productService.findById(id);
    }

    @PostMapping("/create/product")
    public void createProduct(@RequestBody Product product) {
        logger.info("Create product: {}", product);
        productService.save(product).subscribe();
    }

    @PutMapping("/update/product")
    public Mono<Product> updateProduct(@RequestBody Product product) {
        logger.info("Update product: {}", product);
        return productService.save(product);
    }

//    @PutMapping("/update/{id}")
//    public Mono<ResponseEntity<Product>> updateProductById(@PathVariable(value = "id") String id,
//                                                     @RequestBody Product product) {
//        logger.info("Update product by Id: {}", id);
//        return productDao.findById(id)
//                .flatMap(existingProduct -> {
//                    existingProduct.setProductName(product.getProductName());
//                    return productDao.save(existingProduct);
//                })
//                .map(updateProduct -> new ResponseEntity<>(updateProduct, HttpStatus.OK))
//                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }


    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") String id) {
        logger.info("Delete product by Id: {}", id);
        productService.deleteById(id).subscribe();
    }

}
