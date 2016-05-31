package br.ufpr.tcc.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import br.com.spd.model.Aluno;
import br.com.spd.model.Pessoa;
import br.com.spd.model.Professor;

public class CepHandler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RestTemplate restTemplate;
	private final String path = "http://api.postmon.com.br/v1/cep/";
	JsonFactory jfactory = new JsonFactory();
	
	public Aluno getEndereco(Aluno aluno) throws Exception {
		String json = null;
		try{
			String cep = aluno.getCep();
			cep = cep.replace(".", "").replace("-", "");
			json = getRestTemplate().getForObject(path+cep, String.class);
		}catch (Exception e){
			Exception exception = new Exception("CEP inválido");
			throw exception;
		}
		if(json != null){
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map;
			try {
				map = mapper.readValue(json, new TypeReference<Map<String,Object>>(){});
				aluno.setRua(((String) map.get("logradouro")));
				aluno.setCidade((String) map.get("cidade"));
				aluno.setBairro((String) map.get("bairro"));
				aluno.setEstado(((Map<String, String>) map.get("estado_info")).get("nome"));
			} catch (JsonParseException e) {
				e.printStackTrace();
				Exception exception = new Exception("CEP inválido");
				throw exception;
			} catch (JsonMappingException e) {
				e.printStackTrace();
				Exception exception = new Exception("CEP inválido");
				throw exception;
			} catch (IOException e) {
				e.printStackTrace();
				Exception exception = new Exception("CEP inválido");
				throw exception;
			}
			
		}
				
		return aluno;
		
		
	}
	
	public Professor getEndereco(Professor professor) throws Exception {
		String json = null;
		try{
			String cep = professor.getCep();
			cep = cep.replace(".", "").replace("-", "");
			json = getRestTemplate().getForObject(path+cep, String.class);
		}catch (Exception e){
			Exception exception = new Exception("CEP inválido");
			throw exception;
		}
		if(json != null){
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map;
			try {
				map = mapper.readValue(json, new TypeReference<Map<String,Object>>(){});
				professor.setRua(((String) map.get("logradouro")));
				professor.setCidade((String) map.get("cidade"));
				professor.setBairro((String) map.get("bairro"));
				professor.setEstado(((Map<String, String>) map.get("estado_info")).get("nome"));
			} catch (JsonParseException e) {
				e.printStackTrace();
				Exception exception = new Exception("CEP inválido");
				throw exception;
			} catch (JsonMappingException e) {
				e.printStackTrace();
				Exception exception = new Exception("CEP inválido");
				throw exception;
			} catch (IOException e) {
				e.printStackTrace();
				Exception exception = new Exception("CEP inválido");
				throw exception;
			}
			
		}
				
		return professor;
		
		
	}
	
	
	protected RestTemplate getRestTemplate() {
		if(restTemplate == null) {
			restTemplate = new RestTemplate();
			restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		}
		return restTemplate;
	}
}