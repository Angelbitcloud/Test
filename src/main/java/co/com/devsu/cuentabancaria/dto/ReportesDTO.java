package co.com.devsu.cuentabancaria.dto;

import co.com.devsu.cuentabancaria.dto.response.ReportesFechaResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportesDTO {

	private String identificacion;
	
	private String nombrePersona;
    
    private String fecha;
    
    private String numeroCuenta;
    
    private String tipoCuenta;
    
    private Double saldo;
    
    private Double saldoMovimiento;
    
    private Boolean estado;
    
}
