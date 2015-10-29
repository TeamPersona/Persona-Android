package com.modify.pib.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.UUID;

public class ValueOpportunity implements Serializable {

    private static final long serialVersionUID = 1L;

    public final UUID uuid;
    public final String voTitle;
    public final String companyName;
    public final Locale locale;
    public final BigDecimal value;
    public final String shortDescription;
    public final String longDescription;
    public final Integer maxParticipants;
    public final Integer currParticipants;
    public final String imageUrl;

    public ValueOpportunity(
            UUID uuid,
            String voTitle,
            String companyName,
            String imageUrl,
            Locale locale,
            BigDecimal value,
            String shortDescription,
            String longDescription,
            Integer maxParticipants,
            Integer currParticipants) {
        this.uuid = uuid;
        this.voTitle = voTitle;
        this.companyName = companyName;
        this.imageUrl = imageUrl;
        this.locale = locale;
        this.value = value;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.maxParticipants = maxParticipants;
        this.currParticipants = currParticipants;
    }

}
