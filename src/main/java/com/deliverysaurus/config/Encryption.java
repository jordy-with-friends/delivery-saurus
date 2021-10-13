package com.deliverysaurus.config;

import java.util.LinkedHashMap;
import java.util.Map;

public class Encryption {

    private Map<String, EncryptionStrategy> store = new LinkedHashMap<>();

    public void put(String typeName, EncryptionStrategy type) {
        store.put(typeName, type);
    }

    public EncryptionStrategy get(String typeName) {
        return store.get(typeName);
    }
}
