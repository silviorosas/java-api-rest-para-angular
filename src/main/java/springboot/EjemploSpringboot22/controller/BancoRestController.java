/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.EjemploSpringboot22.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.EjemploSpringboot22.model.Banco;
import springboot.EjemploSpringboot22.repository.BancoRepo;

@RestController
@RequestMapping(value="/api/v2/")
@CrossOrigin({"*"})
public class BancoRestController {
    
      @Autowired
    private BancoRepo repo;
    
    @GetMapping(value="/all")
    public List<Banco> getAll(){
        return repo.findAll();
    }
    
     @PostMapping(value="/save")
    public ResponseEntity<Banco> save (@RequestBody Banco producto ){
        Banco obj =repo.save(producto);
        return new ResponseEntity<Banco>(obj,HttpStatus.OK);
    }
    
     @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Banco> delete (@PathVariable Integer id){
        Banco producto = repo.findById(id).get();
        if(producto != null){
            repo.deleteById(id);
        }else{
            return new ResponseEntity<Banco> (producto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Banco>(producto,HttpStatus.OK);
        }

    @GetMapping
    public List<Banco> getFilterBanco(@RequestParam(name = "nombre", required = false) String nombre){
        return repo.findBynombre(nombre);
    }

    @GetMapping("/tasa")
    public List<Banco> getFilterTasa(@RequestParam(name = "tasa", required = false) double tasa){
        return repo.findByTasa(tasa);
    }

    @GetMapping("/nombreAndTasa")
    public List<Banco> getFilterNombreTasa(@RequestParam(name = "nombre", required = false) String nombre,
                                           @RequestParam(name = "tasa", required = false) double tasa){
        return repo.findByNombreAndTasa(nombre,tasa);
    }



}
