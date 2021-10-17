/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.Service;

import co.usa.ciclo3.Model.Reservacion;
import co.usa.ciclo3.Repository.RepositorioReservacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP USER
 */
@Service
public class ServicioReservacion {

    @Autowired
    private RepositorioReservacion metodosCrud;

    public List<Reservacion> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Reservacion> getReservacion(int idReservacion) {
        return metodosCrud.getReservacion(idReservacion);
    }

    public Reservacion save(Reservacion reservacion) {
        if (reservacion.getIdReservation() == null) {
            return metodosCrud.save(reservacion);
        } else {
            Optional<Reservacion> evt = metodosCrud.getReservacion(reservacion.getIdReservation());
            if (evt.isEmpty()) {
                return metodosCrud.save(reservacion);
            } else {
                return reservacion;
            }

        }
    }
}
