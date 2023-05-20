package co.com.devsu.cuentabancaria.dao;

import java.util.List;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.ReportesDTO;

public interface ReportesDAO {

	List<ReportesDTO> obtenerReportes(
			String ferchaInicial, String ferchaFinal, String idCliente
		) throws CuentaBancariaException;
}
