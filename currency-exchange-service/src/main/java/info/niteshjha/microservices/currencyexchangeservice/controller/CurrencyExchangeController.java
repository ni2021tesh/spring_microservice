// Copyright (c) 2018 Travelex Ltd

package info.niteshjha.microservices.currencyexchangeservice.controller;

import info.niteshjha.microservices.currencyexchangeservice.exception.CurrencyNotFoundException;
import info.niteshjha.microservices.currencyexchangeservice.model.CurrencyExchangeBean;
import info.niteshjha.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CurrencyExchangeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Environment environment;

    private CurrencyExchangeService exchangeService;

    public CurrencyExchangeController(CurrencyExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/currency-exchange/from/{fromCurr}/to/{toCurr}")
    public CurrencyExchangeBean getExchangeRate(@PathVariable String fromCurr, @PathVariable String toCurr) {
        logger.info("getting the exchange rate for {} to {} currency", fromCurr, toCurr);

        CurrencyExchangeBean exchangeRate = exchangeService.getExchangeRate(fromCurr, toCurr);
        if (exchangeRate == null) {
            logger.error("error occurred while calling the exchange rate service for {} to {} currency", fromCurr, toCurr);
            throw new CurrencyNotFoundException("Cannot find currency for given fromCurr " + fromCurr + " to toCurr " + toCurr);
        }
        exchangeRate.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));

        logger.info("returning the response back for {} to {} currency", fromCurr, toCurr);
        return exchangeRate;
    }


}
