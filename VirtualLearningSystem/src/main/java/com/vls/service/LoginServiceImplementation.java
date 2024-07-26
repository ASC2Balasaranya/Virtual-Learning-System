package com.vls.service;

import com.vls.repository.LoginRepository;
import com.vls.repository.LoginRepositoryImplementation;

import java.sql.SQLException;

public class LoginServiceImplementation implements LoginService {
    private LoginRepository loginRepository = new LoginRepositoryImplementation();

    @Override
    public boolean authenticateUser(String username, String password) throws SQLException {
        return loginRepository.authenticateUser(username, password);
    }
}

