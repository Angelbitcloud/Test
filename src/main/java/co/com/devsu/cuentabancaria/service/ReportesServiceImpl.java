/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.devsu.cuentabancaria.service;

import org.springframework.stereotype.Service;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.request.ReporteRequest;
import co.com.devsu.cuentabancaria.dto.response.ReportesFechaResponse;

@Service
public class ReportesServiceImpl implements ReportesService {
    
    @Override
    public ReportesFechaResponse reportePorFecha(ReporteRequest request) 
            throws CuentaBancariaException {
        
        return null;
    }
    
    
}
