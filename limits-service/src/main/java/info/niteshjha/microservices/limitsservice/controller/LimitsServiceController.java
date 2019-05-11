// Copyright (c) 2018 Travelex Ltd

package info.niteshjha.microservices.limitsservice.controller;

import info.niteshjha.microservices.limitsservice.config.LimitsPropertiesConfiguration;
import info.niteshjha.microservices.limitsservice.model.LimitsServiceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsServiceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final LimitsPropertiesConfiguration limitsPropertiesConfiguration;

    public LimitsServiceController(LimitsPropertiesConfiguration limitsPropertiesConfiguration) {
        this.limitsPropertiesConfiguration = limitsPropertiesConfiguration;
    }

    @GetMapping("/limits")
    public LimitsServiceBean getLimits() {
        logger.info("Inside {} returning the result..", this.getClass().getName());
        return new LimitsServiceBean(limitsPropertiesConfiguration.getMinimum(), limitsPropertiesConfiguration.getMaximum());
    }

}
