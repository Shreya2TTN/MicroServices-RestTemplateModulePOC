package com.example.restDemo.service;

import com.example.restDemo.entity.Contact;

import java.util.List;

public interface ContactService {
    public Contact createContact(Contact contact);
    public Contact getContact(Integer id);
    public List<Contact> getAll();
    public List<Contact> getByUser(Integer userId);
}
