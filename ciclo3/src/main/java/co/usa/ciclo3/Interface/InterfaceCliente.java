/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.usa.ciclo3.Interface;


import co.usa.ciclo3.Model.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HP USER
 */
public interface InterfaceCliente extends CrudRepository<Cliente, Integer>{
    
}
