package com.apicafe.api.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.apicafe.api.controller.UsuarioController;
import com.apicafe.api.models.Usuario;
import com.apicafe.api.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class usuarioControllerTest {
    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    @Test
    public void userForIdTest() {
        Usuario usuarioTest = new Usuario();
        usuarioTest.setId(1);
        usuarioTest.setUsername("Andres Arriaga");
        usuarioTest.setPassword("123456");

        when(usuarioService.findById(1)).thenReturn(Optional.of(usuarioTest));

        Optional<Usuario> usuario = usuarioController.consultarPorId(1);

        assertNotNull(usuario);
        assertTrue(usuario.isPresent());
        assert usuario.isPresent();
        assert usuario.get().getId() == 1;
        assert usuario.get().getUsername().equals("Andres Arriaga");
        assert usuario.get().getPassword().equals("123456");

    }

    @Test
    public void listUserTest() {
        Usuario usuarioTest = new Usuario(1, "Andres Arriaga", "123456");
        Usuario usuarioTest2 = new Usuario(2, "Yudis Tramoyan", "232323");

        List<Usuario> usuarios = List.of(usuarioTest, usuarioTest2);

        when(usuarioService.findAll()).thenReturn(usuarios);

        List<Usuario> result = usuarioController.listarUsuarios();
        assertNotNull(result);
        assertTrue(result.size() == 2);
        assertEquals(2, result.size());
        assertTrue(result.contains(usuarioTest));
        assertTrue(result.contains(usuarioTest2));

    }

    @Test
    public void updateUserTest() {
        int id = 1;
        Usuario usuarioTest = new Usuario(id, "Andres Arriaga", "123456");
        Usuario usuarioTest2 = new Usuario(id, "Yudis Tramoyan", "232323");

        when(usuarioService.findById(id)).thenReturn(Optional.of(usuarioTest));
        when(usuarioService.save(any(Usuario.class))).thenReturn(usuarioTest2);

        Usuario result = usuarioController.actualizarUsuario(id, usuarioTest);
        assertNotNull(result);
        assertEquals("Yudis Tramoyan", result.getUsername());
        assertEquals("232323", result.getPassword());
        verify(usuarioService, times(1)).findById(id);
        verify(usuarioService, times(1)).save(any(Usuario.class));
    }

    @Test
    public void deleteUserTest() {
        int id = 1;
        usuarioController.eliminarUser(1);

        verify(usuarioService, times(1)).deletById(id);
    }

}
