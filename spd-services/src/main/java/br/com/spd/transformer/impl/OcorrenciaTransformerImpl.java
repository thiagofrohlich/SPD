package br.com.spd.transformer.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spd.domain.Aluno;
import br.com.spd.domain.repository.AlunoRepository;
import br.com.spd.model.Ocorrencia;
import br.com.spd.transformer.OcorrenciaTransformer;

@Service
public class OcorrenciaTransformerImpl implements OcorrenciaTransformer {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private AlunoTransformerImpl alunoTransformer;
	
	@Override
	public br.com.spd.domain.Ocorrencia transformToDomain(Ocorrencia model) {
		br.com.spd.domain.Ocorrencia domain = new br.com.spd.domain.Ocorrencia();
		if(model.getIdocorrencia() != null) {
			domain.setIdocorrencia(model.getIdocorrencia());
		}
		domain.setData(model.getData());
		domain.setDescricao(model.getDescricao());
		domain.setTipo(model.getTipo());
		
		domain.setAluno(findAluno(model.getAluno().getMatricula()));
		
		return domain;
	}

	@Override
	public Ocorrencia transformToModel(br.com.spd.domain.Ocorrencia ocorrencia) {

		Ocorrencia model = new Ocorrencia();
		if(ocorrencia != null) {
			model = new Ocorrencia();
			model.setIdocorrencia(ocorrencia.getIdocorrencia());
			model.setData(ocorrencia.getData());
			model.setDescricao(ocorrencia.getDescricao());
			model.setTipo(ocorrencia.getTipo());
			
			model.setAluno(alunoTransformer.transformToModel(ocorrencia.getAluno()));
		}

		return model;
	}
	
	@Override
	public List<Ocorrencia> transformToModel(List<br.com.spd.domain.Ocorrencia> list) {
		List<Ocorrencia> models = new ArrayList<Ocorrencia>();
		for(br.com.spd.domain.Ocorrencia tipo : list) {
			models.add(transformToModel(tipo));
		}
		return models;
	}
	
	private Aluno findAluno(Long matricula) {
		return alunoRepository.findOne(matricula);
	}

}
