package com.modify.pib.dao;

import com.modify.pib.model.ValueOpportunity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ValueOpportunityProvider {

    public List<ValueOpportunity> readVOs() {
        return Arrays.asList(
                new ValueOpportunity("BestBuy", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSMG4agI3TtqHz2ZoZIHk2ZVRYqdgVZ6k3yy05KlVuLiFsmJQoU", Locale.CHINA, new BigDecimal(2.20), "description", 100, 0),
                new ValueOpportunity("BMW", "http://www.assettocorsa.net/wp-content/uploads/2013/09/logo1.png", Locale.CANADA, new BigDecimal(3.20), "description1", 250, 5),
                new ValueOpportunity("Loblaws", "http://www.unique-foods.com/HTML/images/Logo-Loblaws1.gif", Locale.CANADA, new BigDecimal(5), "description2", 5, 1),
                new ValueOpportunity("Asus", "https://cdn2.iconfinder.com/data/icons/metro-uinvert-dock/256/Asus.png", Locale.CANADA, new BigDecimal(0.5), "description3", 100000, 200),
                new ValueOpportunity("Lenovo", "https://cdn2.iconfinder.com/data/icons/metro-uinvert-dock/256/Lenovo.png", Locale.CANADA, new BigDecimal(1), "description4", 1800, 500)
        );
    }

}
