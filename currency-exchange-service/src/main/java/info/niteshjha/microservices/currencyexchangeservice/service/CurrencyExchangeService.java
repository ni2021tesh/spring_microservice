// Copyright (c) 2018 Travelex Ltd

package info.niteshjha.microservices.currencyexchangeservice.service;

import info.niteshjha.microservices.currencyexchangeservice.model.CurrencyExchangeBean;

public interface CurrencyExchangeService {
    CurrencyExchangeBean getExchangeRate(String from, String to);
}
