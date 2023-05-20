/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.devsu.cuentabancaria.dao;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.ClienteDTO;

public interface ClienteDAO {
    
    String crearCliente(ClienteDTO cliente) throws CuentaBancariaException;
    
    ClienteDTO obtenerCliente(String idCliente) throws CuentaBancariaException;
}
