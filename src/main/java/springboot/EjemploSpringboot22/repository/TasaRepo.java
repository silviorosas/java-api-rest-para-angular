/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.EjemploSpringboot22.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.EjemploSpringboot22.model.Tasa;

/**
 *
 * @author sodac
 */
@Repository
public interface TasaRepo extends JpaRepository<Tasa, Integer>{
    
}
