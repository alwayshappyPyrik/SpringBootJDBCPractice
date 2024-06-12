package com.example.springbootjdbcpractice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class OrderDAO {

    private final String scriptFileName = "scripts/data.sql";

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public OrderDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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
        Map<String, Object> params = new HashMap<>();
        params.put("firstname", firstname);
        List<String> selectProductName = namedParameterJdbcTemplate.query(read(scriptFileName),
                params,
                (rs, rowNum) -> rs.getString("product_name"));
        return String.valueOf(selectProductName);
    }
}
