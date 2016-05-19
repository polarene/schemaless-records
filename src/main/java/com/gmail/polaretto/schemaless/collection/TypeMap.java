/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.polaretto.schemaless.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Minimal implementation of the Typesafe Heterogeneous Container
 *
 * @author Matteo Mirk
 */
public class TypeMap implements Iterable<Map.Entry<Class<?>, Object>> {

    protected final Map<Class<?>, Object> elements = new HashMap<>();

    public <T> TypeMap put(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("Type is null");
        }
        elements.put(type, instance);
        return this;
    }

    public <T> T get(Class<T> type) {
        return type.cast(elements.get(type));
    }

    public boolean hasKey(Class<?> key) {
        return elements.containsKey(key);
    }

    public int size() {
        return elements.size();
    }

    @Override
    public Iterator<Map.Entry<Class<?>, Object>> iterator() {
        return elements.entrySet().iterator();
    }

}
