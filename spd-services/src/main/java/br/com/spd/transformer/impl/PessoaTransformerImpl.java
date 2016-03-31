package br.com.spd.transformer.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.spd.model.Pessoa;
import br.com.spd.transformer.PessoaTransformer;

@Service
public class PessoaTransformerImpl implements PessoaTransformer {
	
	@Override
	public br.com.spd.domain.Pessoa transformToDomain(Pessoa model) {
		br.com.spd.domain.Pessoa domain = new br.com.spd.domain.Pessoa();
		if(model.getCodpessoa() != null) {
			domain.setCodpessoa(model.getCodpessoa());
		}
		domain.setCpf(model.getCpf());
		domain.setCelular(model.getCelular());
		domain.setEscolaridade(model.getEscolaridade());
		domain.setLocaltrabalho(model.getLocaltrabalho());
		domain.setNome(model.getNome());
		domain.setParentesco(model.getParentesco());
		domain.setProfissao(model.getProfissao());
		domain.setResponsavel(model.getResponsavel());
		domain.setRg(model.getRg());
		domain.setTelefone(model.getTelefone());
		return domain;
	}

	@Override
	public Pessoa transformToModel(br.com.spd.domain.Pessoa pessoa) {

		Pessoa model = new Pessoa();
		if(pessoa != null) {
			model = new Pessoa();
			model.setCodpessoa(pessoa.getCodpessoa());
			model.setCpf(pessoa.getCpf());
			model.setCelular(pessoa.getCelular());
			model.setEscolaridade(pessoa.getEscolaridade());
			model.setLocaltrabalho(pessoa.getLocaltrabalho());
			model.setNome(pessoa.getNome());
			model.setParentesco(pessoa.getParentesco());
			model.setProfissao(pessoa.getProfissao());
			model.setResponsavel(pessoa.getResponsavel());
			model.setRg(pessoa.getRg());
			model.setTelefone(pessoa.getTelefone());
		}

		return model;
	}
	
	@Override
	public List<Pessoa> transformToModel(List<br.com.spd.domain.Pessoa> list) {
		List<Pessoa> models = new ArrayList<Pessoa>();
		for(br.com.spd.domain.Pessoa tipo : list) {
			models.add(transformToModel(tipo));
		}
		return models;
	}
	

}
