/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.devsu.cuentabancaria.dao;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.CuentaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CuentasDAOImpl implements CuentasDAO {

    @Autowired
    private JdbcTemplate template;
    
    @Override
    public String crearCuenta(CuentaDTO cuenta) throws CuentaBancariaException {

        try {
            template.update(
                "insert into cuenta("
                    + "clienteId, "
                    + "numeroCuenta, "
                    + "tipoUsuario, "
                    + "saldo,"
                    + "estado) "
                    + "values(?,?,?,?,?)",
                new Object[] {
                    cuenta.getIdCliente(), 
                    cuenta.getNumeroCuenta(),
                    cuenta.getTipoCuenta(),
                    cuenta.getSaldoInicial(),
                    cuenta.isEstado()
                }
            );
            return "Creacion de la cuenta exitosa";
        } catch(DataAccessException e) {
            throw new CuentaBancariaException(
                    "Error guardando los datos"
            );
        }
        
    }

	@Override
	@SuppressWarnings("deprecation")
    public CuentaDTO obtenerCuenta(String idCliente) throws CuentaBancariaException {
        
        try {
            return template.queryForObject(
                "select * from cuenta where idCliente=?", 
                new Object[] {idCliente}, 
                new BeanPropertyRowMapper<>(CuentaDTO.class)
            );
        } catch (EmptyResultDataAccessException e){
            throw new CuentaBancariaException(
                    "No se encontraron registros pertenecientes al usuario"
            );
        }
    }
    
}
