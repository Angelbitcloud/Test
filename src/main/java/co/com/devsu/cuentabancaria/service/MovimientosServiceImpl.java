/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.devsu.cuentabancaria.service;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dao.MovimientoDAO;
import co.com.devsu.cuentabancaria.dto.MovimientoDTO;
import co.com.devsu.cuentabancaria.dto.request.MovimientosRequest;
import co.com.devsu.cuentabancaria.dto.response.CuentasResponse;
import co.com.devsu.cuentabancaria.dto.response.MovimientosResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientosServiceImpl implements MovimientosService {

    @Autowired
    private MovimientoDAO movimientoDao;
    
    @Override
    public CuentasResponse crearMovimiento(MovimientosRequest request) throws CuentaBancariaException {
        try {
            MovimientoDTO movimiento = MovimientoDTO.builder()
                .fecha(request.getFecha())
                .numeroCuenta(request.getNumeroCuenta())
                .tipoMovimiento(request.getTipoMovimiento())
                .saldo(request.getSaldo())
                .valor(request.getValor())
                .build();
            
            String response = movimientoDao.crearMovimiento(movimiento);

            return CuentasResponse.builder()
                    .mensaje(response)
                    .build();
        } catch(CuentaBancariaException e) {
            throw new CuentaBancariaException(
                    "Ocurrio un error almacenando los datos en la bd"
            );
        }
    }

    @Override
    public MovimientosResponse obtenerMovimiento(String numeroCuenta) throws CuentaBancariaException {
        try {
            MovimientoDTO cuenta = movimientoDao.obtenerrMovimiento(numeroCuenta);


            MovimientosResponse response = MovimientosResponse.builder()
                .fecha(cuenta.getFecha())
                .tipoMovimiento(cuenta.getTipoMovimiento())
                .saldo(cuenta.getSaldo())
                .valor(cuenta.getValor())
                .build();
            
            return response;
        } catch (CuentaBancariaException e) {
            throw new CuentaBancariaException(
                    "Ocurrio un error obteniendo los datos en la bd"
            );
        }
    }
    
}
