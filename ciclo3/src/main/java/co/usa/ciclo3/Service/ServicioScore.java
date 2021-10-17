/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.Service;

import co.usa.ciclo3.Model.Score;
import co.usa.ciclo3.Repository.RepositorioScore;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP USER
 */
@Service
public class ServicioScore {
    
    @Autowired
    private RepositorioScore metodosCrud;

    public List<Score> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Score> getScore(int idScore) {
        return metodosCrud.getScore(idScore);
    }

    public Score save(Score score) {
        if (score.getIdScore() == null) {
            return metodosCrud.save(score);
        } else {
            Optional<Score> evt = metodosCrud.getScore(score.getIdScore());
            if (evt.isEmpty()) {
                return metodosCrud.save(score);
            } else {
                return score;
            }

        }

    }    
}
