package com.example.restDemo.service;

import com.example.restDemo.entity.Contact;
import com.example.restDemo.repositories.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    ContactRepo contactRepo;
    @Override
    public Contact createContact(Contact contact) {
        contactRepo.save(contact);
        return contact;
    }

    @Override
    public Contact getContact(Integer id) {
        Contact contact=contactRepo.findById(id).orElse(null);
        return contact;
    }

    @Override
    public List<Contact> getAll() {
        List<Contact> contacts=contactRepo.findAll();
        return contacts;
    }

    @Override
    public List<Contact> getByUser(Integer userId) {
        List<Contact> contacts=contactRepo.findByUserId(userId);
        return contacts;
    }

}
