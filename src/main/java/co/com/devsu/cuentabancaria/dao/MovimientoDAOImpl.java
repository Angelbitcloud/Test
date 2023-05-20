/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.devsu.cuentabancaria.dao;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.MovimientoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MovimientoDAOImpl implements MovimientoDAO {

    @Autowired
    private JdbcTemplate template;
    
    @Override
    public String crearMovimiento(MovimientoDTO mvimiento) throws CuentaBancariaException {
        try {
            template.update(
                "insert into movimiento("
                    + "tipoMovimiento,"
                    + "numeroCuenta,"
                    + "saldo,"
                    + "valor,"
                    + "fecha) "
                    + "values(?,?,?,?,?)",
                new Object[] {
                    mvimiento.getTipoMovimiento(),
                    mvimiento.getNumeroCuenta(),
                    mvimiento.getSaldo(),
                    mvimiento.getValor(),
                    mvimiento.getFecha(), 
                }
            );
            return "Creacion del movimiento exitoso";
        } catch(DataAccessException e) {
            throw new CuentaBancariaException(
                    "Error guardando los datos"
            );
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public MovimientoDTO obtenerrMovimiento(String numeroCuenta) throws CuentaBancariaException {
        try {
            return template.queryForObject(
                "select * from movimiento where numeroCuenta=?", 
                new Object[] {numeroCuenta}, 
                new BeanPropertyRowMapper<>(MovimientoDTO.class)
            );
        } catch (EmptyResultDataAccessException e){
            throw new CuentaBancariaException(
                    "No se encontraron registros pertenecientes al movimiento"
            );
        }
    }
    
}
