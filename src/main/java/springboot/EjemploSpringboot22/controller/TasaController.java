/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.EjemploSpringboot22.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.EjemploSpringboot22.model.Tasa;
import springboot.EjemploSpringboot22.repository.TasaRepo;

/**
 *
 * @author sodac
 */
@RestController
@RequestMapping(value="/api/v3/")
@CrossOrigin({"*"})
public class TasaController {
    
     @Autowired
    private TasaRepo repo;
    
    @GetMapping(value="/all")
    public List<Tasa> getAll(){
        return repo.findAll();
    }
     
     @PostMapping(value="/save")
    public ResponseEntity<Tasa> save (@RequestBody Tasa producto ){
        Tasa obj =repo.save(producto);
        return new ResponseEntity<Tasa>(obj,HttpStatus.OK);
    }
    
      @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Tasa> delete (@PathVariable Integer id){
        Tasa producto = repo.findById(id).get();
        if(producto != null){
            repo.deleteById(id);
        }else{
            return new ResponseEntity<Tasa> (producto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Tasa>(producto,HttpStatus.OK);
        }
    
    
}
