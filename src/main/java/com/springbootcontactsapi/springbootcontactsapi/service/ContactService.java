package com.springbootcontactsapi.springbootcontactsapi.service;

import java.util.List;

import com.springbootcontactsapi.springbootcontactsapi.exception.NoContactException;
import com.springbootcontactsapi.springbootcontactsapi.pojo.Contact;

public interface ContactService {
    // Forcing the ContactServiceImpl to have/override these methods
    Contact getContactById(String id) throws NoContactException;

    void saveContact(Contact contact);

    void updateContact(String id, Contact contact) throws NoContactException;

    void deleteContact(String id) throws NoContactException;

    List<Contact> getContacts();
}
