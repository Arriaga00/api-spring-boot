package com.apicafe.api.controller;

import com.apicafe.api.models.Usuario;
import com.apicafe.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
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
        usuario.setUsername(usuario.getUsername());
        usuario.setPassword(usuario.getPassword());

        return usuarioService.save(usuario);
    }

    @PutMapping("/update/{id}")
    public Usuario actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioExistente.setUsername(usuario.getUsername());
        usuarioExistente.setPassword(usuario.getPassword());
        return usuarioService.save(usuarioExistente);
    }

    @DeleteMapping("deleteUser/{id}")
    public void eliminarUser(@PathVariable Integer id) {
        usuarioService.deletById(id);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> sesion(@RequestBody Usuario user) {
        String message = usuarioService.sessionLogin(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(message);
    }

}
