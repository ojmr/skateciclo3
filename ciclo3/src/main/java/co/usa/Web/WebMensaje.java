/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.Web;

import co.usa.Model.Mensaje;
import co.usa.Services.ServicioMensaje;
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
@RequestMapping("/api/Mesagge")
public class WebMensaje {

    @Autowired
    private ServicioMensaje servicios;

    @GetMapping("/all")
    public List<Mensaje> getMensaje() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Mensaje> getMensaje(@PathVariable("id") int idMensaje) {
        return servicios.getMensaje(idMensaje);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje mensaje) {
        return servicios.save(mensaje);
    }
}