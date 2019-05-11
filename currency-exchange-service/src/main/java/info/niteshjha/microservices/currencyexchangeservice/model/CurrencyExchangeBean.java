// Copyright (c) 2018 Travelex Ltd

package info.niteshjha.microservices.currencyexchangeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURR_EXCHANGE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrencyExchangeBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CURR_ID")
    private Long id;

    @Column(name = "CURR_FROM")
    private String from;

    @Column(name = "CURR_TO")
    private String to;

    @Column(name = "CURR_RATE")
    private BigDecimal conversionFactor;

    private int port = 0;

}
