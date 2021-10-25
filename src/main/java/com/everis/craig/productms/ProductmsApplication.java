package com.everis.craig.productms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
public class ProductmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductmsApplication.class, args);
    }


}


//@SpringBootApplication
//public class ProductmsApplication implements CommandLineRunner {
//
//    @Autowired
//    private ProductDao productDao;
//
//    @Autowired
//    private ReactiveMongoTemplate reactiveMongoTemplate;
//
//    public static final Logger logger = LoggerFactory.getLogger(ProductmsApplication.class);
//
//    public static void main(String[] args) {
//        SpringApplication.run(ProductmsApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        reactiveMongoTemplate.dropCollection("product").subscribe();
//        Flux.just(
//                        new Product("", "", new Politic(
//                                List.of(""), true, true, 1, 1, 1)))
//                .flatMap(product -> {
////                    client.setCreateAt(new Date());
//                    return productDao.save(product);
//                })
//                .subscribe(
//                        product -> logger.info("Insert: " + product.getId() + " " + product.getProductName()));
//    }
//}
