// Copyright (c) 2018 Travelex Ltd

package info.niteshjha.microservices.currencyconversionservice.controller;

import info.niteshjha.microservices.currencyconversionservice.client.CurrencyExchangeServiceProxy;
import info.niteshjha.microservices.currencyconversionservice.model.CurrencyConversionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionConverter {


    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public CurrencyConversionConverter(CurrencyExchangeServiceProxy serviceProxy) {
        this.serviceProxy = serviceProxy;
    }

    private CurrencyExchangeServiceProxy serviceProxy;

    @GetMapping("/currency-converter-feign/from/{fromCurr}/to/{toCurr}/quantity/{quantity}")
    public CurrencyConversionBean getCurrencyExchangeRate(@PathVariable String fromCurr, @PathVariable String toCurr, @PathVariable String quantity) {

        logger.info("Calling currencyExchangeProxyService... ");
        CurrencyConversionBean exchangeRate = serviceProxy.exchangeRate(fromCurr, toCurr);
        logger.info("got result from currencyExchangeProxyService... ");

        exchangeRate.setConversionMultiple(Integer.parseInt(quantity));

        logger.info("calculating the total amount... ");
        exchangeRate.setTotalAmount(exchangeRate.getConversionFactor().multiply(new BigDecimal(exchangeRate.getConversionMultiple())));
        logger.info("returning the request... ");
        return exchangeRate;

    }

}
