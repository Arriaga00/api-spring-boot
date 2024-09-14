package com.apicafe.api.controllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apicafe.api.service.UsuarioService;

@SpringBootTest
public class UsuarioVolumenTestDeleted {
    @Autowired
    UsuarioService usuarioService;

    @Test
    public void testDeleted() {
        int registerNumber = 1000;
        for (int i = 0; i < registerNumber; i++) {
            usuarioService.deletById(i);
        }
    }
}
