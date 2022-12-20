package com.springbootcontactsapi.springbootcontactsapi.service;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcontactsapi.springbootcontactsapi.pojo.Contact;
import com.springbootcontactsapi.springbootcontactsapi.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    
    @Override
    public Contact getContactById(String id) {
        return contactRepository.getContact(findIndexById(id));
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.saveContact(contact);
    }

    @Override
    public void updateContact(String id, Contact contact) {
        contactRepository.updateContact(findIndexById(id), contact);
    }

    @Override
    public void deleteContact(String id) {
        contactRepository.deleteContact(findIndexById(id));
    }


    private int findIndexById(String id) {
        return IntStream.range(0, contactRepository.getContacts().size())
            .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
            .findFirst()
            .orElseThrow();
    }

}
