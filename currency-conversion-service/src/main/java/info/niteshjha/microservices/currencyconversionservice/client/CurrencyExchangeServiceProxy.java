// Copyright (c) 2018 Travelex Ltd

package info.niteshjha.microservices.currencyconversionservice.client;

import info.niteshjha.microservices.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service",url = "http://localhost:8000")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange-service/currency-exchange/from/{fromCurr}/to/{toCurr}")
    public CurrencyConversionBean exchangeRate(@PathVariable String fromCurr, @PathVariable String toCurr);
}

