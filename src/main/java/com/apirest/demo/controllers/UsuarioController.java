package com.apirest.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.demo.models.UsuarioModels;
import com.apirest.demo.services.UsuarioServices;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioServices usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModels> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping(consumes = MediaType.ALL_VALUE)
    public UsuarioModels guardarUsuarios(@RequestBody UsuarioModels usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModels> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<UsuarioModels> obtenerPorNombre(
        @RequestParam(name = "nombre", required = false, defaultValue = "") String nombre, 
        @RequestParam(name = "email", required = false, defaultValue = "") String email){
        
        if (nombre.isEmpty()) return this.usuarioService.obtenerPorEmail(email);
        else return this.usuarioService.obtenerPorNombre(nombre);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se elimino el usuario con id " + id;
        }
        else {
            return "No se pudo eliminar el usuario con id " + id;
        }
    }
}
