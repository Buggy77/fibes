/**
 * 
 */
package com.fibeso.captacion.pfuneraria.controller;

/**
 * @author Javier Pérez Sánchez
 *
 */
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fibeso.captacion.pfuneraria.service.ImprimeConveniosService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class ImprimeConveniosController {

	@Autowired
	private ImprimeConveniosService imprimeConveniosService;

	@RequestMapping(value = { "/imprimeConvenios", "" }, method = RequestMethod.GET)
	 public ModelAndView home() {
		  ModelAndView model = new ModelAndView();

		  model.setViewName("home");
		  return model;
		 }

	
	 @RequestMapping(value = "/imprimeConvenios/export", method = RequestMethod.GET)
	 public void export(ModelAndView model, HttpServletResponse response) throws IOException, JRException, SQLException {
	  JasperPrint jasperPrint = null;

	  response.setContentType("application/x-download");
	  response.setHeader("Content-Disposition", String.format("attachment; filename=\"Convenio.pdf\""));

	  OutputStream out = response.getOutputStream();
	  jasperPrint = imprimeConveniosService.exportPdfFile();
	  JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	 }

}