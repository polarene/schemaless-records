/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gmail.polaretto.schemaless.microtype;

/**
 *
 * @author Matteo Mirk
 */
public class Address {
    private final String address;

    public Address(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return address;
    }
}
