/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gmail.polaretto.schemaless;

import com.gmail.polaretto.schemaless.collection.TypeMap;

/**
 * Schema-less record with a single-valued primary key.
 * @param <K> primary key type
 */
public class Contact<K> extends TypeMap {
    private final Class<K> key;

    public Contact(Class<K> key) {
        this.key = key;
    }

    public Class<K> getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Contact{" + "key=" + key + ", elements=" + elements.size() + '}';
    }

}
