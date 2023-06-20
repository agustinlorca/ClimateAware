/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.climateAware.controladoras;

import com.egg.climateAware.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdministradorControlador {

//    @Autowired
//    AdministadorServicio administradorServicio = new AdministradorServicio();
    
//    @Autowired
//    VotanteServicio votanteServicio = new VotanteServicio();    

//    @Autowired
//    EmpresaServicio empresaServicio = new EmpresaServicio();    
        
    @Autowired
    UsuarioServicio usuarioServicio = new UsuarioServicio();

    @GetMapping("/registro")
    public String registrar() {
        return "usuario_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) String email, @RequestParam(required = false) MultipartFile archivo, 
            @RequestParam(required = false) String contrasena, @RequestParam(required = false) String contrasena2, ModelMap modelo) {

        try {
//            administradorServicio.crearUsuario(archivo, email, contrasena, contrasena2);
            modelo.put("exito", "Usuario regristrado correctamente");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            modelo.put("error", ex.getMessage());
            modelo.put("email", email);
            return "usuario_form.html";
        }

        return "index.html";
    }
    
//LISTA DE TODOS
    @GetMapping("/lista")
    public String lista(ModelMap modelo) {
       modelo.put("usuarios",usuarioServicio.listaUsuarios());
       return "lista.html";
    }
    
//LISTAS SEPARADAS  
     @GetMapping("/listaAdministrador")
    public String listaAdministradores(ModelMap modelo) {
//       modelo.put("administradores".administradorServicio.listaAdministradores());
       return "lista_admin.html";
    }
    
     @GetMapping("/listaEmpresas")
    public String listaEmpresas(ModelMap modelo) {
//       modelo.put("empresas".administradorServicio.listarEmpresas());
       return "lista_empresa.html";
    }
    
     @GetMapping("/listaVotantes")
    public String listaVotantes(ModelMap modelo) {
//       modelo.put("votantes".votanteServicio.listarVotantes());
       return "lista_votante.html";
    }
    
    @GetMapping("/ListaBlogger")
    public String listaBlogger(ModelMap modelo){
//         modelo.put("bloggers".bloggerServicio.listarBloggers());
        return "lista_blogger.html";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@RequestParam @PathVariable String id){
//        usuario.cambiarEstado(id);
        return "index.html";
    }
}
