/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.devsu.cuentabancaria.service;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dao.ClienteDAO;
import co.com.devsu.cuentabancaria.dto.ClienteDTO;
import co.com.devsu.cuentabancaria.dto.request.ClienteRequest;
import co.com.devsu.cuentabancaria.dto.response.CuentasResponse;
import co.com.devsu.cuentabancaria.dto.response.ObtenerClienteResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClienteDAO clienteDao;
    
    @Override
    public CuentasResponse crearCliente(ClienteRequest request) throws CuentaBancariaException {
        try {
            ClienteDTO cliente = ClienteDTO.builder()
                .clienteId(request.getClienteId())
                .clave(request.getClave())
                .estado(request.getEstado())
                .build();
            
            String response = clienteDao.crearCliente(cliente);

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
    public ObtenerClienteResponse obtenerCliente(String idCliente) throws CuentaBancariaException {
        try {
            ClienteDTO cuenta = clienteDao.obtenerCliente(idCliente);
        
            ObtenerClienteResponse response = ObtenerClienteResponse.builder()
                    .clienteId(cuenta.getClienteId())
                    .estado(cuenta.getEstado())
                    .build();

            return response;
        } catch (CuentaBancariaException e) {
            throw new CuentaBancariaException(e.getMensaje());
        }
    }
    
}
