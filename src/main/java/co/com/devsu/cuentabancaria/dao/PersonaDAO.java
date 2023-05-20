package co.com.devsu.cuentabancaria.dao;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.PersonaDTO;

public interface PersonaDAO {

	String crearPersona(PersonaDTO persona) throws CuentaBancariaException;
    
    PersonaDTO obtenerPersona(String idCliente) throws CuentaBancariaException;
    
}
