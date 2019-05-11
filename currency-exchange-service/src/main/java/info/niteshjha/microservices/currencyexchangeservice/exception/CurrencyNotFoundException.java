// Copyright (c) 2018 Travelex Ltd

package info.niteshjha.microservices.currencyexchangeservice.exception;

public class CurrencyNotFoundException extends RuntimeException {
    public CurrencyNotFoundException(String messgae) {
        super(messgae);
    }
}
