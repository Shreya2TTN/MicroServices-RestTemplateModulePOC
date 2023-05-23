package com.example.restDemo.Controller;

import com.example.restDemo.entity.Contact;
import com.example.restDemo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class ContactController {
    @Autowired
    ContactService contactService;
    @GetMapping("/contact/{id}")
    public ResponseEntity<?> getContact(@PathVariable("id")Integer id){
        Contact contact=contactService.getContact(id);
        return ResponseEntity.status(HttpStatus.OK).body(contactService.getContact(id));
    }
    @PostMapping("/contact")
    public ResponseEntity<?> createContact(@RequestBody Contact contact){
        return ResponseEntity.status(HttpStatus.OK).body(contactService.createContact(contact));
    }
    @GetMapping("/contacts")
    public ResponseEntity<?> getContacts(){
        return ResponseEntity.status(HttpStatus.OK).body(contactService.getAll());
    }
    @GetMapping("/contact/user/{id}")
    public List<Contact> getContactByUser(@PathVariable("id") Integer id){
        return contactService.getByUser(id);
    }

}
