package com.modify.pib.dao;

import java.util.List;
import java.util.UUID;

public interface IDataProvider<T> {

    List<T> readAll();
    T readData(UUID uuid);

}
