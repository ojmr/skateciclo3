/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.Service;

import co.usa.ciclo3.Model.Cliente;
import co.usa.ciclo3.Repository.RepositorioCliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP USER
 */
@Service
public class ServicioCliente {

    @Autowired
    private RepositorioCliente metodosCrud;

    public List<Cliente> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Cliente> getCliente(int idCliente) {
        return metodosCrud.getCliente(idCliente);
    }

    public Cliente save(Cliente cliente) {
        if (cliente.getIdClient() == null) {
            return metodosCrud.save(cliente);
        } else {
            Optional<Cliente> evt = metodosCrud.getCliente(cliente.getIdClient());
            if (evt.isEmpty()) {
                return metodosCrud.save(cliente);
            } else {
                return cliente;
            }

        }
    }
}
