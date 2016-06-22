package br.com.spd.rest;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	private ResourceBundle rb = ResourceBundle.getBundle("app");
	
	@Autowired
	public RelatorioController(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	@ResponseBody
	@RequestMapping(value="/alunoTurma/{turma}", method=RequestMethod.GET)
	public byte[] getAlunoPorTurma(@PathVariable final Long turma) {
		Map<String, Object> map = new HashMap<>();
		map.put("turmaId", turma);
		
		return geraRelatorio(map, "Aluno-por-turma.jrxml");
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/ocorrenciaAluno/{aluno}", method=RequestMethod.GET)
	public byte[] getOcorrenciaAluno(@PathVariable final Long aluno) {
		Map<String, Object> map = new HashMap<>();
		map.put("alunoId", aluno);
		
		return geraRelatorio(map, "\\Ocorrencias-por-aluno.jrxml");
	}
	
	@ResponseBody
	@RequestMapping(value="/ocorrenciaTurma/{turma}", method=RequestMethod.GET)
	public byte[] getOcorrenciaTurma(@PathVariable final Long turma) {
		Map<String, Object> map = new HashMap<>();
		map.put("turmaId", turma);
		
		return geraRelatorio(map, "\\Ocorrencias-por-turma.jrxml");
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/avaliacaoAluno/{aluno}/turma/{turma}/trimestre/{trimestre}", method=RequestMethod.GET)
	public byte[] getAvaliacaoAluno(@PathVariable final Long aluno,@PathVariable final Long turma,@PathVariable final String trimestre) {
		Map<String, Object> map = new HashMap<>();
		map.put("alunoId", aluno);
		map.put("trimestre", trimestre);
		
		switch (turma.intValue()) {
		case 1:
			return geraRelatorio(map, "Avaliacoes-por-aluno-maternal.jrxml");
		case 2:
			return geraRelatorio(map, "Avaliacoes-por-aluno-pre1.jrxml");
		case 3:
			return geraRelatorio(map, "Avaliacoes-por-aluno-pre2.jrxml");
		default:
			return null;
			
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/avaliacaoTurma/{turma}/trimestre/{trimestre}/ano/{ano}", method=RequestMethod.GET)
	public byte[] getAvaliacaoTurma(@PathVariable final Long turma,@PathVariable final String trimestre, @PathVariable final String ano) {
		Map<String, Object> map = new HashMap<>();
		map.put("turmaId", turma);
		map.put("trimestre", trimestre);
		map.put("ano", ano);
		switch (turma.intValue()) {
		case 1:
			return geraRelatorio(map, "Avaliacoes-por-turma-maternal.jrxml");
		case 2:
			return geraRelatorio(map, "Avaliacoes-por-turma-pre1.jrxml");
		case 3:
			return geraRelatorio(map, "Avaliacoes-por-turma-pre2.jrxml");
		default:
			return null;
			
		}
	}
	
	
	
	

	private byte[] geraRelatorio(Map<String, Object> map, String relatorio) {
		try{
			Connection conn = DataSourceUtils.getConnection(dataSource);
			SimpleDateFormat format= new SimpleDateFormat("yyyyMMddHHmmss");  
			String id = format.format(new Date());
			JasperReport pathRxml = JasperCompileManager.compileReport(rb.getString("relOrigin")+relatorio);
			JasperPrint printReport = JasperFillManager.fillReport(pathRxml, map, conn);
			if(printReport.getPages().isEmpty()){
				return null;
			}
			JasperExportManager.exportReportToPdfFile(printReport,rb.getString("relDestiny")+id+".pdf");
			File file = new File(rb.getString("relDestiny")+id+".pdf");
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
