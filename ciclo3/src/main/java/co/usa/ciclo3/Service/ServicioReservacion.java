/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.Service;

import co.usa.ciclo3.Model.Reservacion;
import co.usa.ciclo3.Repository.RepositorioReservacion;
import co.usa.ciclo3.reportes.ContadorClientes;
import co.usa.ciclo3.reportes.StatusReservas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public Reservacion update(Reservacion reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservacion> e= metodosCrud.getReservacion(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservacion(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    public StatusReservas getReporteStatusReservaciones(){
        List<Reservacion>completed= metodosCrud.ReservacionStatus("completed");
        List<Reservacion>cancelled= metodosCrud.ReservacionStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());
    }
    
    public List<Reservacion> getReportesTiempoReservaciones(String datoA, String datoB){
        SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempo(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }
    }  
    
    public List<ContadorClientes> servicioTopClientes(){
        return metodosCrud.getTopClientes();
    }
}
