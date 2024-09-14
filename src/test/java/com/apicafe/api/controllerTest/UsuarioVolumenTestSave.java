package com.apicafe.api.controllerTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apicafe.api.controller.UsuarioController;
import com.apicafe.api.models.Usuario;

@SpringBootTest
public class UsuarioVolumenTestSave {
    @Autowired
    UsuarioController usuarioController;

    @Test
    public void testSaveUserVolumen() {
        List<Usuario> usuarios = new ArrayList<>();
        int registernumber = 1000;
        for (int i = 0; i < registernumber; i++) {
            Usuario usuarioTemp = new Usuario();
            usuarioTemp.setUsername("usuario " + i);
            usuarioTemp.setPassword("" + i);
            usuarios.add(usuarioTemp);
        }
        usuarios.forEach(user -> usuarioController.crearUsuario(user));
    }

}
