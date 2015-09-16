package com.modify.pib.model;

import java.math.BigDecimal;
import java.util.Currency;

public class ValueOpportunity {

    private String companyName;
    private Currency currency;
    private BigDecimal value;
    private String description;

    public ValueOpportunity(String companyName, Currency currency, BigDecimal value, String description) {
        this.companyName = companyName;
        this.currency = currency;
        this.value = value;
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
