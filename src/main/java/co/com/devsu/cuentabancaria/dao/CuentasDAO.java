/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.devsu.cuentabancaria.dao;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.CuentaDTO;

public interface CuentasDAO {
    
    String crearCuenta(CuentaDTO cuenta) throws CuentaBancariaException;
    
    CuentaDTO obtenerCuenta(String idCliente) throws CuentaBancariaException;
    
}
