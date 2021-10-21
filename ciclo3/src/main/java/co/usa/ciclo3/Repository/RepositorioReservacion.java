/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.Repository;

import co.usa.ciclo3.Interface.InterfaceReservacion;
import co.usa.ciclo3.Model.Reservacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP USER
 */
@Repository
public class RepositorioReservacion {

    @Autowired
    private InterfaceReservacion crud;

    public List<Reservacion> getAll() {
        return (List<Reservacion>) crud.findAll();
    }

    public Optional<Reservacion> getReservacion(int id) {
        return crud.findById(id);
    }

    public Reservacion save(Reservacion reservacion) {
        return crud.save(reservacion);
    }
    public void delete(Reservacion reservation){
        crud.delete(reservation);
    }
}
