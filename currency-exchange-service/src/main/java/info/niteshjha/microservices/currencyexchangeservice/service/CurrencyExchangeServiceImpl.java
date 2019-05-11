// Copyright (c) 2018 Travelex Ltd

package info.niteshjha.microservices.currencyexchangeservice.service;

import info.niteshjha.microservices.currencyexchangeservice.model.CurrencyExchangeBean;
import info.niteshjha.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private CurrencyExchangeRepository repository;

    public CurrencyExchangeServiceImpl(CurrencyExchangeRepository repository) {
        this.repository = repository;
    }

    @Override
    public CurrencyExchangeBean getExchangeRate(String from, String to) {
        logger.info("Inside {} calling the database..", this.getClass().getName());
        return repository.getCurrencyExchangeBeanByFromAndTo(from, to);
    }
}
