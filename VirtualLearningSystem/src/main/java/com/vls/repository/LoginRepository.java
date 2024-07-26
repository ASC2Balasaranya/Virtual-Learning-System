package com.vls.repository;

import com.vls.model.UserLogin;

import java.sql.SQLException;

public interface LoginRepository {
    boolean authenticateUser(String username, String password) throws SQLException;
}
