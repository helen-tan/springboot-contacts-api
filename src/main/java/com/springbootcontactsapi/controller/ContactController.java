package com.springbootcontactsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springbootcontactsapi.service.ContactService;

@Controller
public class ContactController {
    
    @Autowired
    private ContactService contactService;

}
