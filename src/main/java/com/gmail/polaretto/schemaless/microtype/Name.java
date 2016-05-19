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
public class Name implements Comparable<Name> {
    private final String first, middle, last;

    public Name(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public static Name from(String fullname) {
        String[] split = fullname.split(" +");
        String first = split[0];
        String middle, last;

        if (split.length == 2) {
            middle = "";
            last = split[1];
        } else if (split.length > 2) {
            middle = split[1];
            last = split[2];
        } else {
            middle = "";
            last = "";
        }
        return new Name(first, middle,  last);
    }

    public String getFirst() {
        return first;
    }

    public String getMiddle() {
        return middle;
    }

    public String getLast() {
        return last;
    }

    @Override
    public String toString() {
        return first + " " + middle + " " + last;
    }

    @Override
    public int compareTo(Name o) {
        int result = first.compareToIgnoreCase(o.first);

        if (result == 0) {
            result = last.compareToIgnoreCase(o.last);

            if (result == 0) {
                result = middle.compareToIgnoreCase(o.middle);
            }
        }
        return result;
    }

}
