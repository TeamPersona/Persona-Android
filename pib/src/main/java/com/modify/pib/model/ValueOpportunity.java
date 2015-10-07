package com.modify.pib.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class ValueOpportunity {

    public final String companyName;
    public final Locale locale;
    public final BigDecimal value;
    public final String description;
    public final Integer maxParticipants;
    public final Integer currParticipants;
    public final String imageUrl;

    public ValueOpportunity(
            String companyName,
            String imageUrl,
            Locale locale,
            BigDecimal value,
            String description,
            Integer maxParticipants,
            Integer currParticipants) {
        this.companyName = companyName;
        this.imageUrl = imageUrl;
        this.locale = locale;
        this.value = value;
        this.description = description;
        this.maxParticipants = maxParticipants;
        this.currParticipants = currParticipants;
    }

}
