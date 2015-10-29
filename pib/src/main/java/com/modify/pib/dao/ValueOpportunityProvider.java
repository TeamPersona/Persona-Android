package com.modify.pib.dao;

import com.modify.pib.model.ValueOpportunity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class ValueOpportunityProvider implements IDataProvider<ValueOpportunity> {

    private List<ValueOpportunity> data = Arrays.asList(
            new ValueOpportunity(UUID.randomUUID(), "TV Discount", "BestBuy", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSMG4agI3TtqHz2ZoZIHk2ZVRYqdgVZ6k3yy05KlVuLiFsmJQoU", Locale.CHINA, new BigDecimal(2.20), "description", "longDescription", 100, 0),
            new ValueOpportunity(UUID.randomUUID(), "Test Drive", "BMW", "http://www.assettocorsa.net/wp-content/uploads/2013/09/logo1.png", Locale.CANADA, new BigDecimal(3.20), "description1", "longDescription 1", 250, 5),
            new ValueOpportunity(UUID.randomUUID(), "Food for Sale", "Loblaws", "http://www.unique-foods.com/HTML/images/Logo-Loblaws1.gif", Locale.CANADA, new BigDecimal(5), "description2", "longDescription 2", 5, 1),
            new ValueOpportunity(UUID.randomUUID(), "Back to School Laptop Sale", "Asus", "https://cdn2.iconfinder.com/data/icons/metro-uinvert-dock/256/Asus.png", Locale.CANADA, new BigDecimal(0.5), "description3", "longDescription 3", 100000, 200),
            new ValueOpportunity(UUID.randomUUID(), "Inkjet Printers 65% off", "Lenovo", "https://cdn2.iconfinder.com/data/icons/metro-uinvert-dock/256/Lenovo.png", Locale.CANADA, new BigDecimal(1), "description4", "longDescription 4", 1800, 500)
    );

    public List<ValueOpportunity> readAll() {
        return data;
    }

    @Override
    public ValueOpportunity readData(UUID uuid) {
        // TODO: Use IndexableHashMap to optimize (probably not needed)
        for(ValueOpportunity vo : data) {
            if (vo.uuid.equals(uuid)) {
                return vo;
            }
        }
        return null;
    }

}
