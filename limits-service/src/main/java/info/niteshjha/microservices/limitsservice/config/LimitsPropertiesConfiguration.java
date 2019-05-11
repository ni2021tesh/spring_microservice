// Copyright (c) 2018 Travelex Ltd

package info.niteshjha.microservices.limitsservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "limits-service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LimitsPropertiesConfiguration {

    private int minimum;
    private int maximum;
}
