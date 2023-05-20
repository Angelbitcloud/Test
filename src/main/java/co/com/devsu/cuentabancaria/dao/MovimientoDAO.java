/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.devsu.cuentabancaria.dao;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.MovimientoDTO;

public interface MovimientoDAO {
    
    String crearMovimiento(MovimientoDTO mvimiento) throws CuentaBancariaException;
    
    MovimientoDTO obtenerrMovimiento(String numeroCuenta) throws CuentaBancariaException;
    
}
