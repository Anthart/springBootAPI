package com.apirest.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apirest.demo.models.UsuarioModels;

@Repository
public interface UsuarioRepositories extends CrudRepository<UsuarioModels, Long> {
    public abstract ArrayList<UsuarioModels> findByNombre(String nombre);
    public abstract ArrayList<UsuarioModels> findByEmail(String email);
}