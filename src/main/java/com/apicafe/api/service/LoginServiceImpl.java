package com.apicafe.api.service;

import com.apicafe.api.models.Login;
import com.apicafe.api.repository.LoginRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements  LoginService {

    @Autowired
    LoginRespository loginRespository;

    @Override
    public Login save(Login l) {
        return loginRespository.save(l);
    }

    @Override
    public String sessionLogin(String username, String password) {

        Login usuario = loginRespository.findByUsername(username);

        if(usuario==null){
            return "Usuario no encontrado";
        }

        if(!usuario.getPassword().equals(password)){
            return "Usuario/Contraseña no es correcta";
        }

        return "Usuario Logueado, Bienvenido";
    }
}
