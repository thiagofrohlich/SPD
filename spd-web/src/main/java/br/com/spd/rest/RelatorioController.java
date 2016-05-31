package br.com.spd.rest;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

	private DataSource dataSource;
	
	@Autowired
	public RelatorioController(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	@ResponseBody
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public byte[] getAll() {
		Connection conn = DataSourceUtils.getConnection(dataSource);
		try{
			SimpleDateFormat format= new SimpleDateFormat("yyyyMMddHHmmss");  
			String id = format.format(new Date());
			Map<String, Object> map = new HashMap<>();
			map.put("turmaDescricao", "Maternal II");
			JasperReport pathRxml = JasperCompileManager.compileReport("C:\\Users\\Rodrigo\\Documents\\SPD\\spd-web\\relatorios\\Aluno-por-turma.jrxml");
			JasperPrint printReport = JasperFillManager.fillReport(pathRxml, map, conn);
			JasperExportManager.exportReportToPdfFile(printReport,"C:\\Users\\Rodrigo\\Documents"+id+".pdf");
			File file = new File("C:\\Users\\Rodrigo\\Documents"+id+".pdf");
			FileInputStream fis = new FileInputStream(file);  
	        byte[] data = new byte[fis.available()];  
	        fis.read(data);  
	        fis.close();
	        return data; 
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
}
