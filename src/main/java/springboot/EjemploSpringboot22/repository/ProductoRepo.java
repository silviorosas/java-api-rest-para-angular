/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.EjemploSpringboot22.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.EjemploSpringboot22.model.Producto;

/**
 *
 * @author Soda
 */

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer>{
    
    
    
}
