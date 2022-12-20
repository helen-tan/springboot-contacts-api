package com.springbootcontactsapi.springbootcontactsapi.service;

import com.springbootcontactsapi.springbootcontactsapi.pojo.Contact;

public interface ContactService {
    Contact getContactById(String id);
}
