package com.everis.craig.productms.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "politic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Politic {
    private List<String> clientTypeTarget;
    private boolean descMaintenance;
    private boolean maxLimitMonthlyMovement;
    private Integer maxLimitMonthlyMovementQuantity;
    private Integer maxLimitCreditPerson;
    private Integer getMaxLimitCreditBusiness;
}
