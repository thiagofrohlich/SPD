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
	
	@Autowired
	public RelatorioController(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	@ResponseBody
	@RequestMapping(value="/alunoTurma/{turma}", method=RequestMethod.GET)
	public byte[] getAlunoPorTurma(@PathVariable final Long turma) {
		Map<String, Object> map = new HashMap<>();
		map.put("turmaDescricao", turma);
		
		return geraRelatorio(map, null);
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/ocorrenciaAluno/{aluno}", method=RequestMethod.GET)
	public byte[] getOcorrenciaAluno(@PathVariable final Long aluno) {
		Map<String, Object> map = new HashMap<>();
		map.put("aluno", aluno);
		
		return geraRelatorio(map, null);
	}
	
	@ResponseBody
	@RequestMapping(value="/ocorrenciaTurma/{turma}", method=RequestMethod.GET)
	public byte[] getOcorrenciaTurma(@PathVariable final Long turma) {
		Map<String, Object> map = new HashMap<>();
		map.put("turma", turma);
		
		return geraRelatorio(map, null);
	}
	
	@ResponseBody
	@RequestMapping(value="/aluno/{aluno}/ocorrencia/{ocorrencia}", method=RequestMethod.GET)
	public byte[] getAlunoOcorrencia(@PathVariable final Long aluno, @PathVariable final Long ocorrencia) {
		Map<String, Object> map = new HashMap<>();
		map.put("aluno", aluno);
		map.put("ocorrencia", ocorrencia);
		return geraRelatorio(map, null);
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/turma/{turma}/avaliacaoAluno/{aluno}", method=RequestMethod.GET)
	public byte[] getAvaliacaAluno(@PathVariable final Long turma,@PathVariable final Long aluno) {
		Map<String, Object> map = new HashMap<>();
		map.put("turma", turma);
		map.put("aluno", aluno);
		switch (turma.intValue()) {
		case 1:
			return geraRelatorio(map, null);
		case 2:
			return geraRelatorio(map, null);
		case 3:
			return geraRelatorio(map, null);
		default:
			return null;
			
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/turma/{turma}", method=RequestMethod.GET)
	public byte[] getAvaliacaAluno(@PathVariable final Long turma) {
		Map<String, Object> map = new HashMap<>();
		map.put("turma", turma);
		switch (turma.intValue()) {
		case 1:
			return geraRelatorio(map, null);
		case 2:
			return geraRelatorio(map, null);
		case 3:
			return geraRelatorio(map, null);
		default:
			return null;
			
		}
	}
	
	
	
	

	private byte[] geraRelatorio(Map<String, Object> map, String relatorio) {
		try{
			Connection conn = DataSourceUtils.getConnection(dataSource);
			SimpleDateFormat format= new SimpleDateFormat("yyyyMMddHHmmss");  
			String id = format.format(new Date());
			JasperReport pathRxml = JasperCompileManager.compileReport(relatorio);
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
