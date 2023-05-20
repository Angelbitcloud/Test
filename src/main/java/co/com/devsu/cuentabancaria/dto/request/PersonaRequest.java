package co.com.devsu.cuentabancaria.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonaRequest {

	private String nombre;
    
    private String genero;
    
    private int edad;
    
    private String identificaicon;
    
    private String direccion;
    
    private String telefono;
    
}
