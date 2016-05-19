/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gmail.polaretto.schemaless;

/**
 *
 * @author Matteo Mirk
 */
public class FormatNulls {
    public static class NullValue {
        private final String s;

        public NullValue(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return s;
        }
    }

    private static final NullValue DEF_NULL_VALUE = new NullValue("");

    public static String format(String format, Object... args) {
        return format(DEF_NULL_VALUE, format, args);
    }

    public static String format(NullValue value, String format, Object... args) {
        String nullValue = value.toString();
        for (int i = 0; i < args.length; i++) {
            args[i] = value(args[i], nullValue);
        }
        return String.format(format, args);
    }

    public static <T> T value(T in, T def) {
        return in == null ? def : in;
    }
}
