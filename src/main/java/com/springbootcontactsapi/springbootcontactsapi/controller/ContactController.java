package com.springbootcontactsapi.springbootcontactsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcontactsapi.springbootcontactsapi.pojo.Contact;
import com.springbootcontactsapi.springbootcontactsapi.service.ContactService;

@RestController // @Controller + @ResponseBody (serializes an object into json)
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    // Get a Contact by id
    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
        Contact contact = contactService.getContactById(id);

        return new ResponseEntity<>(contact, HttpStatus.OK);
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
        contactService.updateContact(id, contact);

        return new ResponseEntity<>(contactService.getContactById(id), HttpStatus.OK);
    }

}
