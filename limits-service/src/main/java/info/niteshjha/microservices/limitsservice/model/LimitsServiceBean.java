// Copyright (c) 2018 Travelex Ltd

package info.niteshjha.microservices.limitsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LimitsServiceBean {
    private int minimum;
    private int maximum;
}
