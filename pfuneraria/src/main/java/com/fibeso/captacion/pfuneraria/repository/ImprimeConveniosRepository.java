/**
 * 
 */
package com.fibeso.captacion.pfuneraria.repository;

/**
 * @author Javier Pérez Sánchez
 *
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.PrinterName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimplePrintServiceExporterConfiguration;

@Transactional
@Repository
public class ImprimeConveniosRepository {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ResourceLoader resourceLoader;

	public JasperPrint exportPdfFile() throws SQLException, JRException, IOException {
		Connection conn = jdbcTemplate.getDataSource().getConnection();

		conn.setCatalog("fibesocap");
		conn.setSchema("esqfibeso");
		
		String path = resourceLoader.getResource("classpath:Convenio.jrxml").getURI().getPath();

		JasperReport jasperReport = JasperCompileManager.compileReport(path);

		// Parameters for report
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("FolioConvenio","DOC-CREM-20190104-00001-00001");

		JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

		return print;
	}	
}
