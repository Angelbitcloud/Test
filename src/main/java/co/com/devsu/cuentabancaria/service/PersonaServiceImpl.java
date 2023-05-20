package co.com.devsu.cuentabancaria.service;

import org.springframework.stereotype.Service;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dao.PersonaDAO;
import co.com.devsu.cuentabancaria.dto.PersonaDTO;
import co.com.devsu.cuentabancaria.dto.request.PersonaRequest;
import co.com.devsu.cuentabancaria.dto.response.CuentasResponse;
import co.com.devsu.cuentabancaria.dto.response.ObtenerPersonaResponse;

@Service
public class PersonaServiceImpl implements PersonaService {

	
	private PersonaDAO personaDAO;
	
	@Override
	public CuentasResponse crearPersona(PersonaRequest request) throws CuentaBancariaException {
		try {
			PersonaDTO persona = PersonaDTO.builder()
					.identificaicon(request.getIdentificaicon())
					.nombre(request.getNombre())
					.genero(request.getGenero())
					.edad(request.getEdad())
					.direccion(request.getDireccion())
					.telefono(request.getTelefono())
					.build();
            
            String response = personaDAO.crearPersona(persona);

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
	public ObtenerPersonaResponse obtenerPersona(String idCliente) throws CuentaBancariaException {
		try {
			PersonaDTO persona = personaDAO.obtenerPersona(idCliente);
        
			ObtenerPersonaResponse personaResponse = ObtenerPersonaResponse.builder()
					.identificaicon(persona.getIdentificaicon())
					.nombre(persona.getNombre())
					.genero(persona.getGenero())
					.edad(persona.getEdad())
					.direccion(persona.getDireccion())
					.telefono(persona.getTelefono())
					.build();

            return personaResponse;
        } catch (CuentaBancariaException e) {
            throw new CuentaBancariaException(e.getMensaje());
        }
	}

}
