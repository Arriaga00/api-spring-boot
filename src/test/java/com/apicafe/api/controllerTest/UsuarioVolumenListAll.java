package com.apicafe.api.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apicafe.api.models.Usuario;
import com.apicafe.api.service.UsuarioService;

@SpringBootTest
public class UsuarioVolumenListAll {
    @Autowired
    UsuarioService usuarioService;

    @Test
    public void testListAllUserVolumen() {
        int registernumber = 1000;
        List<Usuario> usuarios = usuarioService.findAll();
        assertEquals(registernumber, usuarios.size());
    }

}
