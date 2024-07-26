package com.vls.repository;

import com.vls.model.UserLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginRepositoryImplementation implements LoginRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/VLSDB";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load driver", e);
        }
    }

    @Override
    public boolean authenticateUser(String username, String password) throws SQLException {
        String sql = "SELECT * FROM Login WHERE username = '" + username + "' AND password = '" + password + "'";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            return rs.next();
        }    }

}
