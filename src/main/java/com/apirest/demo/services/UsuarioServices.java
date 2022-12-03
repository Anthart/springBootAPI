package com.apirest.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.demo.models.UsuarioModels;
import com.apirest.demo.repositories.UsuarioRepositories;

@Service
public class UsuarioServices {
    @Autowired
    UsuarioRepositories usuarioRepositories;

    public ArrayList<UsuarioModels> obtenerUsuarios(){
        return (ArrayList<UsuarioModels>)this.usuarioRepositories.findAll();
    }

    public UsuarioModels guardarUsuario(UsuarioModels usuario){
        return this.usuarioRepositories.save(usuario);
    }

    public Optional<UsuarioModels> obtenerPorId(Long id){
        return this.usuarioRepositories.findById(id);
    }

    public ArrayList<UsuarioModels> obtenerPorNombre(String nombre){
        return this.usuarioRepositories.findByNombre(nombre);
    }

    public ArrayList<UsuarioModels> obtenerPorEmail(String email){
        return this.usuarioRepositories.findByEmail(email);
    }

    public boolean eliminarUsuario(Long id){
        try{
            this.usuarioRepositories.deleteById(id);
            return true;
        }
        catch(Exception error){
            return false;
        }
    }
    
}
