/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.devsu.cuentabancaria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.ClienteDTO;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

    @Autowired
    private JdbcTemplate template;
    
    @Override
    public String crearCliente(ClienteDTO cliente) throws CuentaBancariaException {
        try {
        	
        	String estado = cliente.getEstado() ? "true" : "false";
        	
            template.update(
                "insert into cliente("
                    + "clienteId, "
                    + "clave, "
                    + "estado) "
                    + "values(?,?,?)",
                new Object[] {
                    cliente.getClienteId(), 
                    cliente.getClave(),
                    estado
                }
            );
            return "Creacion del cliente exitoso";
        } catch(DataAccessException e) {
            throw new CuentaBancariaException(
                    "Error guardando los datos"
            );
        }
    }
    
	@Override
	@SuppressWarnings("deprecation")
    public ClienteDTO obtenerCliente(String idCliente) throws CuentaBancariaException {
        
        try {
            return template.queryForObject(
                "select * from cliente where clienteId=?", 
                new Object[] {idCliente}, 
                new BeanPropertyRowMapper<>(ClienteDTO.class)
            );
        } catch (EmptyResultDataAccessException e){
            throw new CuentaBancariaException(
                    "No se encontraron registros pertenecientes al usuario"
            );
        }
    }
    
}
