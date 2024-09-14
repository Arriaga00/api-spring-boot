package com.apicafe.api.controllerTest;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.apicafe.api.controller.UsuarioController;
import com.apicafe.api.models.Usuario;

@SpringBootTest
public class UsuarioVolumentTestUpdate {
    @Autowired
    UsuarioController usuarioController;

    @Test
    public void testUpdate() {
        int registerNumber = 1000;

        for (int i = 0; i < registerNumber; i++) {
            Optional<Usuario> usuarioOpt = usuarioController.consultarPorId(i);
            if (usuarioOpt.isPresent()) {
                Usuario usuario = usuarioOpt.get();
                usuario.setUsername("usuario actualizado " + i);
                usuario.setPassword("password actualizado " + i);
                usuarioController.crearUsuario(usuario);
            }
        }

        for (int i = 0; i < registerNumber; i++) {
            Optional<Usuario> usuarioOpt = usuarioController.consultarPorId(i);
            if (usuarioOpt.isPresent()) {
                assertEquals("usuario actualizado " + i, usuarioOpt.get().getUsername());
            }
        }

    }
}
