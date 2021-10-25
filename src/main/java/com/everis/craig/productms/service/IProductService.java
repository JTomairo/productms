package com.everis.craig.productms.service;

import com.everis.craig.productms.documents.Product;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;



public interface IProductService {
     Flux<Product> findAll();
     Mono<Product> findById(String id);
     Mono<Product> save(Product product);
     Mono<Product> update(Product product);
     Mono<Void> deleteById(String id);

}
