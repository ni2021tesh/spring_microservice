// Copyright (c) 2018 Travelex Ltd

package info.niteshjha.microservices.currencyconversionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrencyConversionBean {
    private Long id;

    private String from;

    private String to;

    private BigDecimal conversionFactor;

    private Integer conversionMultiple;

    private BigDecimal totalAmount;

    private int port = 0;
}
