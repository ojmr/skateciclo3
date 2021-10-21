/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.Repository;

import co.usa.ciclo3.Interface.InterfaceMensaje;
import co.usa.ciclo3.Model.Mensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP USER
 */
@Repository
public class RepositorioMensaje {

    @Autowired
    private InterfaceMensaje crud;

    public List<Mensaje> getAll() {
        return (List<Mensaje>) crud.findAll();
    }

    public Optional<Mensaje> getMensaje(int id) {
        return crud.findById(id);
    }

    public Mensaje save(Mensaje mensaje) {
        return crud.save(mensaje);
    }
    public void delete(Mensaje message){
        crud.delete(message);
    }
}
