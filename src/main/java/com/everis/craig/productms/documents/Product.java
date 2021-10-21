package com.everis.craig.productms.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
@Getter
@Setter
public class Product {

    @Id
    private String Id;
    private String productName;
    private String productYpe;
    private Politic politic;

    public Product(String productName, String productYpe, Politic politic) {
        this.productName = productName;
        this.productYpe = productYpe;
        this.politic = politic;
    }
}
