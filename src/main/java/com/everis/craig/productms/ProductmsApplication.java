package com.everis.craig.productms;

import com.everis.craig.productms.dao.ProductDao;
import com.everis.craig.productms.documents.Politic;
import com.everis.craig.productms.documents.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

import java.util.List;

@SpringBootApplication
public class ProductmsApplication implements CommandLineRunner {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    public static final Logger logger = LoggerFactory.getLogger(ProductmsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductmsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        reactiveMongoTemplate.dropCollection("product").subscribe();
        Flux.just(
                        new Product("", "", new Politic(
                                List.of(""), true, true, 1, 1, 1)))
                .flatMap(product -> {
//                    client.setCreateAt(new Date());
                    return productDao.save(product);
                })
                .subscribe(
                        product -> logger.info("Insert: " + product.getId() + " " + product.getProductName()));
    }
}
