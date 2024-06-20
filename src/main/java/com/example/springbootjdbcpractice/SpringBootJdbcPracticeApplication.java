package com.example.springbootjdbcpractice;

import com.example.springbootjdbcpractice.model.Customer;
import com.example.springbootjdbcpractice.model.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringBootJdbcPracticeApplication implements CommandLineRunner {

    @PersistenceContext
    private final EntityManager entityManager;

    public SpringBootJdbcPracticeApplication(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcPracticeApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {
        Order order = Order.builder()
                .localDateTime(LocalDateTime.now())
                .productName("Майка")
                .amount(300)
                .build();

        entityManager.persist(order);

        order = entityManager.getReference(Order.class, 1L);

        Customer customer = Customer.builder()
                .firstname("yaroslav")
                .surname("pyrikov")
                .age((short) 31)
                .phoneNumber("")
                .order(order)
                .build();

        entityManager.persist(customer);
    }
}
