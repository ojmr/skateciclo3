/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.Repository;

import co.usa.ciclo3.Interface.InterfaceScore;
import co.usa.ciclo3.Model.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP USER
 */
@Repository
public class RepositorioScore {
    
    @Autowired
    private InterfaceScore crud;
    
    public List<Score> getAll(){
        return (List<Score>) crud.findAll();
    }
    
    public Optional <Score> getScore(int id){
        return crud.findById(id);
    }
    
    public Score save(Score score){
        return crud.save(score);
    }    
}
