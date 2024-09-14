package com.apicafe.api.controllerTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apicafe.api.controller.UsuarioController;
import com.apicafe.api.models.Usuario;

@SpringBootTest
public class UsuarioVolumenTestList {
    @Autowired
    UsuarioController usuarioController;

    @Test
    public void testListUserVolumen() {
        int registernumber = 1000;
        for (int i = 1; i < registernumber; i++) {
            Optional<Usuario> usuario = usuarioController.consultarPorId(i);
            assertTrue(usuario.isPresent());
        }
    }
}
