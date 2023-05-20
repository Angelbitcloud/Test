/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.devsu.cuentabancaria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportesFechaResponse {
	
	private String identificacion;
	
	private String nombrePersona;
    
    private String fecha;
    
    private String numeroCuenta;
    
    private String tipoCuenta;
    
    private Double saldo;
    
    private Double saldoMovimiento;
    
    private Boolean estado;
    
}
