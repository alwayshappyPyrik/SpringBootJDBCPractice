package com.example.springbootjdbcpractice.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Repository
public class OrderDAO {

    private final String scriptFileName = "db.changelog/migrations/data_v1.sql";

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    public OrderDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String firstname) {
        Query query = entityManager.createNativeQuery(read(scriptFileName), String.class);
        query.setParameter("firstname", firstname);
        return query.getResultList().toString();
    }
}
