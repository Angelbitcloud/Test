/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.devsu.cuentabancaria.service;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.request.MovimientosRequest;
import co.com.devsu.cuentabancaria.dto.response.CuentasResponse;
import co.com.devsu.cuentabancaria.dto.response.MovimientosResponse;

public interface MovimientosService {
    
    CuentasResponse crearMovimiento(MovimientosRequest request) throws CuentaBancariaException;
    
    MovimientosResponse obtenerMovimiento(String numeroCuenta) throws CuentaBancariaException;
    
}
