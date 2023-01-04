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

import com.springbootcontactsapi.response.ResponseHandler;
import com.springbootcontactsapi.springbootcontactsapi.exception.NoContactException;
import com.springbootcontactsapi.springbootcontactsapi.pojo.Contact;
import com.springbootcontactsapi.springbootcontactsapi.service.ContactService;

import jakarta.validation.Valid;

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
    public ResponseEntity<Object> getContact(@PathVariable String id) {
        try {
            Contact contact = contactService.getContactById(id);
    
            //return new ResponseEntity<>(contact, HttpStatus.OK);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, contact);
        } catch(NoContactException e) {
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseHandler.generateResponse("Resource not found", HttpStatus.NOT_FOUND, null);
        }
    }

    // Create a contact
    @PostMapping("/contact")
    public ResponseEntity<Object> createContact(@Valid @RequestBody Contact contact) {
        contactService.saveContact(contact);

        // return new ResponseEntity<>(HttpStatus.CREATED);
        return ResponseHandler.generateResponse("Resource successfully created", HttpStatus.CREATED, contact);
    }

    // Update a contact
    @PutMapping("/contact/{id}")
    public ResponseEntity<Object> updateContact(@PathVariable String id, @Valid @RequestBody Contact contact) {
        try {
            contactService.updateContact(id, contact);
    
            // return new ResponseEntity<>(contactService.getContactById(id), HttpStatus.OK);
            return ResponseHandler.generateResponse("Resource updated successfully", HttpStatus.OK, contactService.getContactById(id));
        } catch(NoContactException e) {
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return ResponseHandler.generateResponse("Resource not found", HttpStatus.BAD_REQUEST, null);
        }
    }

    // Delete a contact
    @DeleteMapping("/delete/{id}/contact") // path was changed to demo requestMatchers in securityConfig
    public ResponseEntity<Object> deleteContact(@PathVariable String id) {
        try {
            contactService.deleteContact(id);
    
            // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseHandler.generateResponse("Resource deleted successfully", HttpStatus.OK, null);
        } catch(NoContactException e) {
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseHandler.generateResponse("Resource not found", HttpStatus.NOT_FOUND, null);
        }
    }

}
