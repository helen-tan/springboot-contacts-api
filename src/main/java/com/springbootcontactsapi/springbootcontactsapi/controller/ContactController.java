package com.springbootcontactsapi.springbootcontactsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcontactsapi.springbootcontactsapi.pojo.Contact;
import com.springbootcontactsapi.springbootcontactsapi.service.ContactService;

@RestController // @Controller + @ResponseBody (serializes an object into json)
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact/{id}")
    public Contact getContact(@PathVariable String id) {
        return new Contact("123", "Jon Snow", "12345678");
    }
}
