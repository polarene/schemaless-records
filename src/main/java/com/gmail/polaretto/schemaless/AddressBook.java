/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.polaretto.schemaless;

import com.gmail.polaretto.schemaless.microtype.Address;
import com.gmail.polaretto.schemaless.microtype.Name;
import com.gmail.polaretto.schemaless.microtype.Phone;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Matteo Mirk
 * @param <K> the primary key type
 */
public class AddressBook<K extends Comparable<K>> {
    /**
     * index or primary key type
     */
    private final Class<K> key;

    /**
     * schema-less records
     */
    private final SortedSet<Contact<K>> contacts;


    /**
     * default key type is String
     */
//    public AddressBook() {
//        this(String.class);
//    }
    /**
     *
     * @param key
     */
    public AddressBook(final Class<K> key) {
        this.key = key;
        this.contacts = new TreeSet<>( //                new Comparator<Contact<K>>() {
                //            /**
                //             * entries are sorted by key type
                //             * @param e1
                //             * @param o2
                //             * @return
                //             */
                //            @Override
                //            public int compare(Contact<K> e1, Contact<K> e2) {
                //                return e1.get(key).compareTo(e2.get(key));
                //            }
                //        }
                );
    }

    public AddressBook<K> add(Contact<K> entry) {
//        if (/*!entry.hasKey(getKey())*/ !entry.getKey().equals(key)) {
//            throw new IllegalArgumentException(entry.toString());
//        }
        contacts.add(entry);
        return this;
    }

    public Class<K> getKey() {
        return key;
    }

    public AddressBook<K> remove(Contact<K> o) {
        contacts.remove(o);
        return this;
    }

    public boolean contains(Contact<K> o) {
        return contacts.contains(o);
    }

    public int size() {
        return contacts.size();
    }

//    public SortedSet<Contact<K>> find(K name) {
//        Contact<Name> low = new Contact<>(Name.class);
//        low.put(Name.class, Name.from(name));
//        Contact<Name> high = new Contact<>(Name.class);
//        low.put(Name.class, Name.from(name + Character.MAX_VALUE));
//
//        return Collections.unmodifiableSortedSet(contacts.subSet(low, high));
//    }

//    public SortedSet<Contact<K>> contacts(char letter) {
//        return find(String.valueOf(letter));
//    }

    public Contact<K> find(Object field) {
        for (Contact<K> entry : contacts) {
            if (field.equals(entry.get(field.getClass()))) {
                return entry;
            }
        }
        return null;
    }

    public static void main(String[] args) throws MalformedURLException {
        AddressBook<Name> book = new AddressBook<>(Name.class); // explicit key class
        Contact<Name> contact = new Contact<>(Name.class);
        contact.put(Name.class, Name.from("Mario Rossi"))
                .put(Phone.class, new Phone("06123456"));
        book.add(contact);

        contact = new Contact<>(Name.class);
        contact.put(Name.class, Name.from("Francesco Verdone"))
                .put(Phone.class, new Phone("3351244556699"));
        book.add(contact);

        contact = new Contact<>(Name.class);
        contact.put(Name.class, Name.from("Marco cazzi"))
                .put(Phone.class, new Phone("335124415600"))
                .put(Address.class, new Address("v. le palle dal culo 69"))
                // add any column you want!
                .put(String.class, "personal notes...");

        Calendar bdate = Calendar.getInstance();
        bdate.set(1982, 10, 25);

        // birthday!
        contact.put(Date.class, new Date(bdate.getTimeInMillis()));

        // website!
        contact.put(URL.class, new URL("www.cazzimm.it"));
        book.add(contact);

        System.out.println(book.size() + " entries in book.");
        String input = "mar";

//        System.out.println("search: " + input);
//        SortedSet<Contact<Name>> found = book.find(input);

//        if (!found.isEmpty()) {
//            for (Contact<Name> c : found) {
//                System.out.println(FormatNulls.format("-> %s | %s | %s",
//                        c.get(Name.class), c.get(Phone.class), c.get(Address.class))
//                );
//            }
//        } else {
//            System.out.println("No results.");
//        }
    }
}
