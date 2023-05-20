package co.com.devsu.cuentabancaria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.PersonaDTO;

@Repository
public class PersonaDAOImpl implements PersonaDAO {
	
	@Autowired
    private JdbcTemplate template;

	@Override
	public String crearPersona(PersonaDTO persona) throws CuentaBancariaException {

		try {
        	
            template.update(
                "insert into personas("
                    + "identificacion, "
                    + "nombre, "
                    + "genero,"
                    + "edad,"
                    + "telefono,"
                    + "direccion) "
                    + "values(?,?,?)",
                new Object[] {
                		persona.getIdentificaicon(), 
                		persona.getNombre(),
                		persona.getGenero(),
                		persona.getEdad(),
                		persona.getTelefono(),
                		persona.getDireccion()
                }
            );
            return "Creacion de la persona exitoso";
        } catch(DataAccessException e) {
            throw new CuentaBancariaException(
                    "Error guardando los datos"
            );
        }
	}

	@Override
	@SuppressWarnings("deprecation")
	public PersonaDTO obtenerPersona(String idCliente) throws CuentaBancariaException {
		try {
            return template.queryForObject(
                "select * from personas where identificacion=?", 
                new Object[] {idCliente}, 
                new BeanPropertyRowMapper<>(PersonaDTO.class)
            );
        } catch (EmptyResultDataAccessException e){
            throw new CuentaBancariaException(
                    "No se encontraron registros pertenecientes al usuario"
            );
        }
	}

}
