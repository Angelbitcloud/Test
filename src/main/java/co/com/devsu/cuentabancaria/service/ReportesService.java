/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.devsu.cuentabancaria.service;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.request.ReporteRequest;
import co.com.devsu.cuentabancaria.dto.response.ReportesFechaResponse;

public interface ReportesService {
    
    ReportesFechaResponse reportePorFecha(ReporteRequest request) 
            throws CuentaBancariaException;
    
}
