package com.everis.craig.productms;

import com.everis.craig.productms.documents.Product;
import com.everis.craig.productms.service.IProductService;
import com.everis.craig.productms.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.mongodb.assertions.Assertions.assertTrue;

@SpringBootTest
class ProductmsApplicationTests {



    @Test
    void contextLoads() {
    }


}
