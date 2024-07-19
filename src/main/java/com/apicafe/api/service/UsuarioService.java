package com.apicafe.api.service;

import com.apicafe.api.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

     public Optional<Usuario>findById(Integer id);
     public List<Usuario>findAll();
     public Usuario save(Usuario u);
     public void deletById(Integer id);


}
