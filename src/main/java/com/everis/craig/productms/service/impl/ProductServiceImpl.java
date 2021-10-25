package com.everis.craig.productms.service.impl;

import com.everis.craig.productms.documents.Product;
import com.everis.craig.productms.repository.ProductRepository;
import com.everis.craig.productms.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return productRepository.deleteById(id);
    }


}
