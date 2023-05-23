package com.example.restDemo.repositories;

import com.example.restDemo.entity.Contact;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer> {
    List<Contact> findByUserId(Integer id);
}