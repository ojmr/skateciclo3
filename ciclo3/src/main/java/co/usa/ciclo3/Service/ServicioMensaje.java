/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.Service;

import co.usa.ciclo3.Model.Mensaje;
import co.usa.ciclo3.Repository.RepositorioMensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP USER
 */
@Service
public class ServicioMensaje {

    @Autowired
    private RepositorioMensaje metodosCrud;

    public List<Mensaje> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Mensaje> getMensaje(int idMensaje) {
        return metodosCrud.getMensaje(idMensaje);
    }

    public Mensaje save(Mensaje mensaje) {
        if (mensaje.getIdMessage() == null) {
            return metodosCrud.save(mensaje);
        } else {
            Optional<Mensaje> evt = metodosCrud.getMensaje(mensaje.getIdMessage());
            if (evt.isEmpty()) {
                return metodosCrud.save(mensaje);
            } else {
                return mensaje;
            }

        }
    }
    public Mensaje update(Mensaje message){
        if(message.getIdMessage()!=null){
            Optional<Mensaje> e= metodosCrud.getMensaje(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMensaje(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
