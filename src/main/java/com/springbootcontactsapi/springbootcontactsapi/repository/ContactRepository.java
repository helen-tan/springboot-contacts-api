package com.springbootcontactsapi.springbootcontactsapi.repository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbootcontactsapi.springbootcontactsapi.pojo.Contact;

@Repository
public class ContactRepository {
    // Contact Resources will be stored in this ArrayList
    // private List<Contact> contacts = new ArrayList<>();
    private List<Contact> contacts = Arrays.asList(
        new Contact("123", "Jon Snow", "12345678"),
        new Contact("456", "Tyrion Lannister", "12345678"),
        new Contact("789", "Joffrey Baratheon", "12345678")
    );

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact(int index) {
        return contacts.get(index);
    }

    public void saveContact(Contact contact) {
        contacts.add(contact);
    }

    public void updateContact(int index, Contact contact) { 
        contacts.set(index, contact); 
    }
    
    public void deleteContact(int index) {
        contacts.remove(index);
    }

}