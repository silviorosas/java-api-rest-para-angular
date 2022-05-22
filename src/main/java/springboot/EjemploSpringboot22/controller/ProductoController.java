/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.EjemploSpringboot22.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.EjemploSpringboot22.model.Producto;
import springboot.EjemploSpringboot22.repository.ProductoRepo;

/**
 *
 * @author Soda
 */
@Controller
@RequestMapping("/productos")//localhost:8080/productos
public class ProductoController {
    
    private final Logger logg= LoggerFactory.getLogger(Producto.class);
    
    @Autowired
    private ProductoRepo repo;
    
       
    @GetMapping("")
    public String home(Model model){
        //traigo la lista de la BD y se la paso a la variable productos 
        model.addAttribute("productos",repo.findAll());
        return"home";
    }
    
    @GetMapping("/create")
    public String create(){
        return"create";
    }
    
    @PostMapping("/save")
    public String save(Producto producto){
        //logg es para hacer una prueba
        logg.info("Informacion del objeto producto, {}", producto);
        
        repo.save(producto);
    //guardo y redirecciona a productos
        return"redirect:/productos";
    }
    
     @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Producto p= repo.getById(id);
        logg.info("Objeto recupetrado {}", p);
        model.addAttribute("producto", p);
        return"edit";
    }
    
    //copio y pego el edit ya que es muy parecido
     @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Producto p= repo.getById(id);
        logg.info("Objeto eliminado {}", p);
       repo.delete(p);
        return"redirect:/productos";
    }
}
