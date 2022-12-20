package com.springbootcontactsapi.springbootcontactsapi.service;

import java.util.List;

import com.springbootcontactsapi.springbootcontactsapi.pojo.Contact;

public interface ContactService {
    // Forcing the ContactServiceImpl to have/override these methods
    Contact getContactById(String id);

    void saveContact(Contact contact);

    void updateContact(String id, Contact contact);

    void deleteContact(String id);

    List<Contact> getContacts();
}
