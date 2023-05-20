/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.devsu.cuentabancaria.service;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dao.CuentasDAO;
import co.com.devsu.cuentabancaria.dto.CuentaDTO;
import co.com.devsu.cuentabancaria.dto.request.CuentaRequest;
import co.com.devsu.cuentabancaria.dto.response.CuentasResponse;
import co.com.devsu.cuentabancaria.dto.response.ObtenerCuentaResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentasServiceImpl implements CuentasService {

    @Autowired
    private CuentasDAO cuentaDao;
    
    @Override
    public CuentasResponse crearCuenta(CuentaRequest request) throws CuentaBancariaException {
        
        try {
            CuentaDTO cuenta = CuentaDTO.builder()
                .numeroCuenta(request.getNumeroCuenta())
                .tipoCuenta(request.getTipoCuenta())
                .saldoInicial(request.getSaldoInicial())
                .estado(request.isEstado())
                .idCliente(request.getIdCliente())
                .build();
            
            String response = cuentaDao.crearCuenta(cuenta);

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
    public ObtenerCuentaResponse obtenerCuenta(String idCliente) throws CuentaBancariaException {
        
        try {
            CuentaDTO cuenta = cuentaDao.obtenerCuenta(idCliente);
        
            ObtenerCuentaResponse response = ObtenerCuentaResponse.builder()
                    .numeroCuenta(cuenta.getNumeroCuenta())
                    .tipoCuenta(cuenta.getTipoCuenta())
                    .saldoInicial(cuenta.getSaldoInicial())
                    .estado(cuenta.isEstado())
                    .idCliente(cuenta.getIdCliente())
                    .build();

            return response;
        } catch (CuentaBancariaException e) {
            throw new CuentaBancariaException(
                    "Ocurrio un error obteniendo los datos en la bd"
            );
        }
        
    }
    
}
