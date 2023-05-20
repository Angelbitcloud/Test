/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.devsu.cuentabancaria.controller;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.request.ReporteRequest;
import co.com.devsu.cuentabancaria.dto.response.ReportesFechaResponse;
import co.com.devsu.cuentabancaria.service.ReportesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/reportes")
public class ReportesControlador {
    
    @Autowired
    private ReportesService reportesService;
    
    @ApiOperation(value = "Motodo para obtener los datos de las cuentas", nickname = "reportePorFecha")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "200", response = ReportesFechaResponse.class),
            @ApiResponse(code = 400, message = "400")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReportesFechaResponse> reportePorFecha (
            @Valid
            @RequestBody
            ReporteRequest request) throws CuentaBancariaException {
            return new ResponseEntity<>(reportesService.reportePorFecha(request), HttpStatus.OK);
    }
    
}
