
package springboot.EjemploSpringboot22.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.EjemploSpringboot22.model.Producto;
import springboot.EjemploSpringboot22.repository.ProductoRepo;


@RestController
@RequestMapping(value="/api/v1/")
@CrossOrigin({"*"})
public class ProductoRestController {
    
    @Autowired
    private ProductoRepo repo;
    
    @GetMapping(value="/all")
    public List<Producto> getAll(){
        return repo.findAll();
    }
    
     @PostMapping(value="/save")
    public ResponseEntity<Producto> save (@RequestBody Producto producto ){
        Producto obj =repo.save(producto);
        return new ResponseEntity<Producto>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Producto> delete (@PathVariable Integer id){
        Producto producto = repo.findById(id).get();
        if(producto != null){
            repo.deleteById(id);
        }else{
            return new ResponseEntity<Producto> (producto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Producto>(producto,HttpStatus.OK);
        }

    @GetMapping
    public List<Producto> getFilterProducto(@RequestParam(name = "nombre", required = false) String nombre){
        return repo.findBynombre(nombre);
    }
}
