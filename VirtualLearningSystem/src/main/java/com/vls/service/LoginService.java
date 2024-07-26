package com.vls.service;

import java.sql.SQLException;

public interface LoginService {
    boolean authenticateUser(String username, String password) throws SQLException;
}

