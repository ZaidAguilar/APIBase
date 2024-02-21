package com.services.solutions.apibase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;

@Service
public class DatabaseService {

    private final DataSource dataSource;

    @Autowired
    public DatabaseService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean isDatabaseConnected() {
        try (Connection connection = dataSource.getConnection()) {
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}