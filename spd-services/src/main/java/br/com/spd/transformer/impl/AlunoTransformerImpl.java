package br.com.spd.transformer.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spd.domain.Pessoa;
import br.com.spd.domain.repository.PessoaRepository;
import br.com.spd.model.Aluno;
import br.com.spd.transformer.AlunoTransformer;

@Service
public class AlunoTransformerImpl implements AlunoTransformer {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaTransformerImpl pessoaTransformer;
	
	@Override
	public br.com.spd.domain.Aluno transformToDomain(Aluno model) {
		br.com.spd.domain.Aluno domain = new br.com.spd.domain.Aluno();
		if(model.getMatricula() != null) {
			domain.setMatricula(model.getMatricula());
		}
		domain.setAlergia(model.getAlergia());
		domain.setAnoinicio(model.getAnoinicio());
		domain.setAnoletivo(model.getAnoletivo());
		domain.setBairro(model.getBairro());
		domain.setCep(model.getCep());
		domain.setCidade(model.getCidade());
		domain.setCirurgias(model.getCirurgias());
		domain.setCodmed(model.getCodmed());
		domain.setDatanasc(model.getDatanasc());
		domain.setEmail(model.getEmail());
		domain.setEstado(model.getEstado());
		domain.setHorario(model.getHorario());
		domain.setModalidade(model.getModalidade());
		domain.setNivel(model.getNivel());
		domain.setNome(model.getNome());
		domain.setNumero(model.getNumero());
		domain.setPeriodo(model.getPeriodo());
		domain.setReligiao(model.getReligiao());
		domain.setRestalimentar(model.getRestalimentar());
		domain.setRua(model.getRua());
		domain.setSerie(model.getSerie());
		domain.setSitpais(model.getSitpais());
		domain.setTelefone(model.getTelefone());
		domain.setTemperamento(model.getTemperamento());
		domain.setTratamento(model.getTratamento());
		domain.setValor(model.getValor());
		
//		domain.setAvaliacaoMat1s(avaliacaoMat1s);
//		domain.setAvaliacaoMat2s(avaliacaoMat2s);
//		domain.setAvaliacaoPre1s(avaliacaoPre1s);
//		domain.setAvaliacaoPre2s(avaliacaoPre2s);
//		
		domain.setPessoa(findPessoa(model.getPessoa().getCodpessoa()));
		return domain;
	}

	@Override
	public Aluno transformToModel(br.com.spd.domain.Aluno aluno) {

		Aluno model = new Aluno();
		if(aluno != null) {
			model = new Aluno();
			model.setMatricula(aluno.getMatricula());
			model.setAlergia(aluno.getAlergia());
			model.setAnoinicio(aluno.getAnoinicio());
			model.setAnoletivo(aluno.getAnoletivo());
			model.setBairro(aluno.getBairro());
			model.setCep(aluno.getCep());
			model.setCidade(aluno.getCidade());
			model.setCirurgias(aluno.getCirurgias());
			model.setCodmed(aluno.getCodmed());
			model.setDatanasc(aluno.getDatanasc());
			model.setEmail(aluno.getEmail());
			model.setEstado(aluno.getEstado());
			model.setHorario(aluno.getHorario());
			model.setModalidade(aluno.getModalidade());
			model.setNivel(aluno.getNivel());
			model.setNome(aluno.getNome());
			model.setNumero(aluno.getNumero());
			model.setPeriodo(aluno.getPeriodo());
			model.setReligiao(aluno.getReligiao());
			model.setRestalimentar(aluno.getRestalimentar());
			model.setRua(aluno.getRua());
			model.setSerie(aluno.getSerie());
			model.setSitpais(aluno.getSitpais());
			model.setTelefone(aluno.getTelefone());
			model.setTemperamento(aluno.getTemperamento());
			model.setTratamento(aluno.getTratamento());
			model.setValor(aluno.getValor());
			
//			domain.setAvaliacaoMat1s(avaliacaoMat1s);
//			domain.setAvaliacaoMat2s(avaliacaoMat2s);
//			domain.setAvaliacaoPre1s(avaliacaoPre1s);
//			domain.setAvaliacaoPre2s(avaliacaoPre2s);
//			
			model.setPessoa(pessoaTransformer.transformToModel(aluno.getPessoa()));
		}

		return model;
	}
	
	@Override
	public List<Aluno> transformToModel(List<br.com.spd.domain.Aluno> list) {
		List<Aluno> models = new ArrayList<Aluno>();
		for(br.com.spd.domain.Aluno tipo : list) {
			models.add(transformToModel(tipo));
		}
		return models;
	}
	
	private Pessoa findPessoa(Long codPessoa) {
		return pessoaRepository.findOne(codPessoa);
	}

}
