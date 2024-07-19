package com.apicafe.api.controller;

import com.apicafe.api.models.Usuario;
import com.apicafe.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/userC")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/{id}")
    public Optional<Usuario> consultarPorId(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    @GetMapping("/listUser")
    public List<Usuario> listarUsuarios() {
        return usuarioService.findAll();
    }

    @PostMapping("/saveUser")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        usuario.setId(usuario.getId());
        usuario.setUser(usuario.getUser());
        return usuarioService.save(usuario);
    }

    @PutMapping("/update/{id}")
    public Usuario actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioExistente.setUser(usuario.getUser());
        return usuarioService.save(usuarioExistente);
    }

    @DeleteMapping("deleteUser/{id}")
    public void eliminarUser(@PathVariable Integer id) {
        usuarioService.deletById(id);
    }

}
