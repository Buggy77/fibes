/**
 * 
 */
package com.fibeso.captacion.pfuneraria.service;

/**
 * @author Javier Pérez Sánchez
 *
 */
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibeso.captacion.pfuneraria.repository.ImprimeConveniosRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class ImprimeConveniosService {

	@Autowired
	private ImprimeConveniosRepository imprimeConvenios;

	public JasperPrint exportPdfFile() throws SQLException, JRException, IOException {
		return imprimeConvenios.exportPdfFile();
	}

}