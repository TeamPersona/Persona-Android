package com.modify.pib.dao;

import com.modify.pib.model.ValueOpportunity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class ValueOpportunityProvider {

    public List<ValueOpportunity> readVOs() {
        return Arrays.asList(
                new ValueOpportunity("BestBuy", Currency.getInstance(Locale.CANADA), new BigDecimal(2.20), "description"),
                new ValueOpportunity("BMW", Currency.getInstance(Locale.CANADA), new BigDecimal(3.20), "description1"),
                new ValueOpportunity("Loblaws", Currency.getInstance(Locale.CANADA), new BigDecimal(5), "description2"),
                new ValueOpportunity("Asus", Currency.getInstance(Locale.CANADA), new BigDecimal(0.5), "description3"),
                new ValueOpportunity("Lenovo", Currency.getInstance(Locale.CANADA), new BigDecimal(1), "description4")
        );
    }

}
