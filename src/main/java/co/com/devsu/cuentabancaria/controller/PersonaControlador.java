package co.com.devsu.cuentabancaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.request.PersonaRequest;
import co.com.devsu.cuentabancaria.dto.response.CuentasResponse;
import co.com.devsu.cuentabancaria.dto.response.ObtenerPersonaResponse;
import co.com.devsu.cuentabancaria.service.PersonaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping("/personas")
public class PersonaControlador {

	@Autowired
    private PersonaService personaService;
    
    @ApiOperation(value = "Motodo para crtear las personas", nickname = "crearPersona")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "200", response = CuentasResponse.class),
            @ApiResponse(code = 400, message = "400")
    })
    @PostMapping(value = "/crear-persona", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CuentasResponse> crearPersona (
            @Valid
            @RequestBody
            PersonaRequest request) throws CuentaBancariaException {
            return new ResponseEntity<>(personaService.crearPersona(request), HttpStatus.OK);
    }
    
    @ApiOperation(value = "Motodo para obtener los datos de las personas", nickname = "obtenerPersona")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "200", response = ObtenerPersonaResponse.class),
            @ApiResponse(code = 400, message = "400")
    })
    @GetMapping(value = "/obtener-persona/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObtenerPersonaResponse> obtenerPersona (
            @Valid
            @PathVariable("idCliente")
            String idCliente) throws CuentaBancariaException {
            return new ResponseEntity<>(personaService.obtenerPersona(idCliente), HttpStatus.OK);
    }
}
