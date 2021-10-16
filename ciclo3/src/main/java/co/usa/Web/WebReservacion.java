/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.Web;

import co.usa.Model.Reservacion;
import co.usa.Services.ServicioReservacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP USER
 */
@RestController
@RequestMapping("/api/Reservation")
public class WebReservacion {

    @Autowired
    private ServicioReservacion servicios;

    @GetMapping("/all")
    public List<Reservacion> getReservacion() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservacion> getReservacion(@PathVariable("id") int idReservacion) {
        return servicios.getReservacion(idReservacion);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion save(@RequestBody Reservacion reservacion) {
        return servicios.save(reservacion);
    }
}
