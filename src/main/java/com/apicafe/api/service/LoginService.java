package com.apicafe.api.service;

import com.apicafe.api.models.Login;

public interface LoginService  {
    public Login save(Login l);
    public String sessionLogin(String username, String password);
}
