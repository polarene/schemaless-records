/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gmail.polaretto.schemaless.collection;

import com.gmail.polaretto.schemaless.microtype.Phone;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class PhoneList implements Iterable<Phone>{
    private final List<Phone> numbers;

    public PhoneList() {
        this(new LinkedList<Phone>());
    }

    public PhoneList(Phone... numbers) {
        this(Arrays.asList(numbers));
    }

    public PhoneList(List<Phone> numbers) {
        this.numbers = new LinkedList<>(numbers);
    }

    public boolean add(Phone p) {
        return numbers.add(p);
    }

    public boolean remove(Phone p) {
        return numbers.remove(p);
    }

    @Override
    public Iterator<Phone> iterator() {
        return numbers.iterator();
    }

}
