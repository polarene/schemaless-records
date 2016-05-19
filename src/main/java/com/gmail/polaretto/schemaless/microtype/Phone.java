/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gmail.polaretto.schemaless.microtype;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author Matteo Mirk
 */
public class Phone {
    private static final Pattern PHONE = Pattern.compile("\\+?\\d[\\d ()-]*");

    public static enum Type {
        PERSONAL,
        HOME,
        OFFICE,
        FAX
    }

    private final String phone;
    private Type type;

    public Phone(String phone) {
        this(phone, Type.PERSONAL);
    }

    public Phone(String phone, Type t) {
        check(phone);
        this.phone = phone;
        this.type = t;
    }

    private void check(String phone) {
        if (!PHONE.matcher(phone).matches()) {
            throw new IllegalArgumentException(phone);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.phone);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Phone other = (Phone) obj;

        return Objects.equals(this.phone, other.phone);
    }

    @Override
    public String toString() {
        return phone;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
