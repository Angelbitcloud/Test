/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.devsu.cuentabancaria.service;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.request.ClienteRequest;
import co.com.devsu.cuentabancaria.dto.response.CuentasResponse;
import co.com.devsu.cuentabancaria.dto.response.ObtenerClienteResponse;

public interface ClientesService {
 
    CuentasResponse crearCliente(ClienteRequest request) throws CuentaBancariaException;
    
    ObtenerClienteResponse obtenerCliente(String idCliente) throws CuentaBancariaException;
}
