package co.com.devsu.cuentabancaria.service;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.request.PersonaRequest;
import co.com.devsu.cuentabancaria.dto.response.CuentasResponse;
import co.com.devsu.cuentabancaria.dto.response.ObtenerPersonaResponse;

public interface PersonaService {
	
	CuentasResponse crearPersona(PersonaRequest request) throws CuentaBancariaException;
    
	ObtenerPersonaResponse obtenerPersona(String idCliente) throws CuentaBancariaException;

}
