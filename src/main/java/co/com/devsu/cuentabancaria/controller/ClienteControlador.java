/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.devsu.cuentabancaria.controller;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.request.ClienteRequest;
import co.com.devsu.cuentabancaria.dto.response.CuentasResponse;
import co.com.devsu.cuentabancaria.dto.response.ObtenerClienteResponse;
import co.com.devsu.cuentabancaria.dto.response.ObtenerCuentaResponse;
import co.com.devsu.cuentabancaria.service.ClientesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClienteControlador {
    
    @Autowired
    private ClientesService clientesService;
    
    @ApiOperation(value = "Motodo para crtear las cuentas", nickname = "crearCliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "200", response = CuentasResponse.class),
            @ApiResponse(code = 400, message = "400")
    })
    @PostMapping(value = "/crear-cliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CuentasResponse> crearCliente (
            @Valid
            @RequestBody
            ClienteRequest request) throws CuentaBancariaException {
            return new ResponseEntity<>(clientesService.crearCliente(request), HttpStatus.OK);
    }
    
    @ApiOperation(value = "Motodo para obtener los datos de las cuentas", nickname = "obtenerCliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "200", response = ObtenerCuentaResponse.class),
            @ApiResponse(code = 400, message = "400")
    })
    @GetMapping(value = "/obtener-cliente/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObtenerClienteResponse> obtenerCliente (
            @Valid
            @PathVariable("idCliente")
            String idCliente) throws CuentaBancariaException {
            return new ResponseEntity<>(clientesService.obtenerCliente(idCliente), HttpStatus.OK);
    }
}
