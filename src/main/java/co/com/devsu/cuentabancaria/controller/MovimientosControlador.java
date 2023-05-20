/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.devsu.cuentabancaria.controller;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.request.MovimientosRequest;
import co.com.devsu.cuentabancaria.dto.response.CuentasResponse;
import co.com.devsu.cuentabancaria.dto.response.MovimientosResponse;
import co.com.devsu.cuentabancaria.dto.response.ObtenerCuentaResponse;
import co.com.devsu.cuentabancaria.service.MovimientosService;
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
@RequestMapping("/movimientos")
public class MovimientosControlador {
    
    @Autowired
    private MovimientosService movimientosService;
    
    @ApiOperation(value = "Motodo para crtear los movimientos", nickname = "crearMovimiento")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "200", response = CuentasResponse.class),
            @ApiResponse(code = 400, message = "400")
    })
    @PostMapping(value = "/crear-cuenta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CuentasResponse> crearMovimiento (
            @Valid
            @RequestBody
            MovimientosRequest request) throws CuentaBancariaException {
            return new ResponseEntity<>(movimientosService.crearMovimiento(request), HttpStatus.OK);
    }
    
    @ApiOperation(value = "Motodo para obtener los datos de los movmientos", nickname = "obtenerMovimiento")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "200", response = ObtenerCuentaResponse.class),
            @ApiResponse(code = 400, message = "400")
    })
    @GetMapping(value = "/obtener-cuenta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovimientosResponse> obtenerMovimiento (
            @Valid
            @PathVariable
            String numeroCuenta) throws CuentaBancariaException {
            return new ResponseEntity<>(movimientosService.obtenerMovimiento(numeroCuenta), HttpStatus.OK);
    }
}
