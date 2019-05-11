// Copyright (c) 2018 Travelex Ltd

package info.niteshjha.microservices.currencyexchangeservice.repository;

import info.niteshjha.microservices.currencyexchangeservice.model.CurrencyExchangeBean;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyExchangeRepository extends CrudRepository<CurrencyExchangeBean, Long> {

    CurrencyExchangeBean getCurrencyExchangeBeanByFromAndTo(String from, String to);
}
