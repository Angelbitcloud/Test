package co.com.devsu.cuentabancaria.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.ReportesDTO;

@Repository
public class ReportesDAOImpl implements ReportesDAO {

	 @Autowired
	    private JdbcTemplate template;
	 
	@Override
	@SuppressWarnings("deprecation")
	public List<ReportesDTO> obtenerReportes(String ferchaInicial, String ferchaFinal, String idCliente)
			throws CuentaBancariaException {
		try {
            return template.query(
                "select * from reportes where clienteId = ? and fecha between ? and ?", 
                new Object[] {
                		idCliente,
                		ferchaInicial,
                		ferchaFinal}, 
                new BeanPropertyRowMapper<>(ReportesDTO.class)
            );
        } catch (EmptyResultDataAccessException e){
            throw new CuentaBancariaException(
                    "No se encontraron registros pertenecientes al usuario"
            );
        }
	}

}
