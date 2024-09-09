package com.apicafe.api.service;

import com.apicafe.api.models.Usuario;
import com.apicafe.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario save(Usuario u) {
        return usuarioRepository.save(u);
    }

    @Override
    public void deletById(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public String sessionLogin(String username, String password) {

        Usuario usuario = usuarioRepository.findByUsername(username);

        if (usuario == null) {
            return "Usuario no encontrado";
        }

        if (!usuario.getPassword().equals(password)) {
            return "Usuario/Contraseña no es correcta";
        }

        return "Usuario Logueado, Bienvenido";
    }
}
