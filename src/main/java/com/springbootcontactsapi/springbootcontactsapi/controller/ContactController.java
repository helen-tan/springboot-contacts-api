package com.springbootcontactsapi.springbootcontactsapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcontactsapi.springbootcontactsapi.exception.NoContactException;
import com.springbootcontactsapi.springbootcontactsapi.pojo.Contact;
import com.springbootcontactsapi.springbootcontactsapi.service.ContactService;

@RestController // @Controller + @ResponseBody (serializes an object into json)
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    // Get the list of all contacts
    @GetMapping("/contact/all")
    public ResponseEntity<List<Contact>> getContacts() {
        List<Contact> contacts = contactService.getContacts();

        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    // Get a Contact by id
    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
        try {
            Contact contact = contactService.getContactById(id);
    
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } catch(NoContactException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a contact
    @PostMapping("/contact")
    public ResponseEntity<HttpStatus> createContact(@RequestBody Contact contact) {
        contactService.saveContact(contact);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Update a contact
    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable String id, @RequestBody Contact contact) {
        try {
            contactService.updateContact(id, contact);
    
            return new ResponseEntity<>(contactService.getContactById(id), HttpStatus.OK);
        } catch(NoContactException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Delete a contact
    @DeleteMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id) {
        try {
            contactService.deleteContact(id);
    
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(NoContactException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
