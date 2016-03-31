package br.com.spd.transformer.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spd.domain.Aluno;
import br.com.spd.domain.repository.AlunoRepository;
import br.com.spd.model.AvaliacaoPre1;
import br.com.spd.transformer.AlunoTransformer;
import br.com.spd.transformer.AvaliacaoPre1Transformer;

@Service
public class AvaliacaoPre1TransformerImpl implements AvaliacaoPre1Transformer {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private AlunoTransformer alunoTransformer;
	
	@Override
	public br.com.spd.domain.AvaliacaoPre1 transformToDomain(AvaliacaoPre1 model) {
		br.com.spd.domain.AvaliacaoPre1 domain = new br.com.spd.domain.AvaliacaoPre1();
		if(model.getCodavaliacao() != null) {
			domain.setCodavaliacao(model.getCodavaliacao());
			domain.setTrimestre(model.getTrimestre());
		}
		
		domain.setArtCria(model.getArtCria());
		domain.setArtExplora(model.getArtExplora());
		domain.setArtUtiliza(model.getArtUtiliza());
		domain.setLingInterage(model.getLingInterage());
		domain.setLingOuve(model.getLingOuve());
		domain.setLingPensamento(model.getLingPensamento());
		domain.setLingReconheceIlust(model.getLingReconheceIlust());
		domain.setLingReconheceNome(model.getLingReconheceNome());
		domain.setLingRegistra(model.getLingRegistra());
		domain.setLingRelata(model.getLingRelata());
		domain.setMatCompara(model.getMatCompara());
		domain.setMatCompreende(model.getMatCompreende());
		domain.setMatContagem(model.getMatContagem());
		domain.setMatParticipa(model.getMatParticipa());
		domain.setMatPercebeAtributos(model.getMatPercebeAtributos());
		domain.setMatPercebeComparacao(model.getMatPercebeComparacao());
		domain.setMatRealizaContagem(model.getMatRealizaContagem());
		domain.setNatIdentificaComunicacao(model.getNatIdentificaComunicacao());
		domain.setNatPapeis(model.getNatPapeis());
		domain.setNatParticipaJogos(model.getNatParticipaJogos());
		domain.setNatReconheceFamilia(model.getNatReconheceFamilia());
		domain.setNatRelacao(model.getNatRelacao());
		domain.setNatValoriza(model.getNatValoriza());
		domain.setSocConhece(model.getSocConhece());
		domain.setSocCuida(model.getSocCuida());
		domain.setSocExpressa(model.getSocExpressa());
		domain.setSocIniciativa(model.getSocIniciativa());
		domain.setSocInteresseEscolar(model.getSocInteresseEscolar());
		domain.setSocNomenclatura(model.getSocNomenclatura());
		domain.setSocRelaciona(model.getSocRelaciona());
		
		domain.setAluno(findAluno(model.getAluno().getMatricula()));
		
		return domain;
	}

	@Override
	public AvaliacaoPre1 transformToModel(br.com.spd.domain.AvaliacaoPre1 avaliacaoPre1) {

		AvaliacaoPre1 model = new AvaliacaoPre1();
		if(avaliacaoPre1 != null) {
			model = new AvaliacaoPre1();
			model.setCodavaliacao(avaliacaoPre1.getCodavaliacao());
			
			model.setArtCria(avaliacaoPre1.getArtCria());
			model.setArtExplora(avaliacaoPre1.getArtExplora());
			model.setArtUtiliza(avaliacaoPre1.getArtUtiliza());
			model.setLingInterage(avaliacaoPre1.getLingInterage());
			model.setLingOuve(avaliacaoPre1.getLingOuve());
			model.setLingPensamento(avaliacaoPre1.getLingPensamento());
			model.setLingReconheceIlust(avaliacaoPre1.getLingReconheceIlust());
			model.setLingReconheceNome(avaliacaoPre1.getLingReconheceNome());
			model.setLingRegistra(avaliacaoPre1.getLingRegistra());
			model.setLingRelata(avaliacaoPre1.getLingRelata());
			model.setMatCompara(avaliacaoPre1.getMatCompara());
			model.setMatCompreende(avaliacaoPre1.getMatCompreende());
			model.setMatContagem(avaliacaoPre1.getMatContagem());
			model.setMatParticipa(avaliacaoPre1.getMatParticipa());
			model.setMatPercebeAtributos(avaliacaoPre1.getMatPercebeAtributos());
			model.setMatPercebeComparacao(avaliacaoPre1.getMatPercebeComparacao());
			model.setMatRealizaContagem(avaliacaoPre1.getMatRealizaContagem());
			model.setNatIdentificaComunicacao(avaliacaoPre1.getNatIdentificaComunicacao());
			model.setNatPapeis(avaliacaoPre1.getNatPapeis());
			model.setNatParticipaJogos(avaliacaoPre1.getNatParticipaJogos());
			model.setNatReconheceFamilia(avaliacaoPre1.getNatReconheceFamilia());
			model.setNatRelacao(avaliacaoPre1.getNatRelacao());
			model.setNatValoriza(avaliacaoPre1.getNatValoriza());
			model.setSocConhece(avaliacaoPre1.getSocConhece());
			model.setSocCuida(avaliacaoPre1.getSocCuida());
			model.setSocExpressa(avaliacaoPre1.getSocExpressa());
			model.setSocIniciativa(avaliacaoPre1.getSocIniciativa());
			model.setSocInteresseEscolar(avaliacaoPre1.getSocInteresseEscolar());
			model.setSocNomenclatura(avaliacaoPre1.getSocNomenclatura());
			model.setSocRelaciona(avaliacaoPre1.getSocRelaciona());
			
			model.setAluno(alunoTransformer.transformToModel(avaliacaoPre1.getAluno()));
		}

		return model;
	}
	
	@Override
	public List<AvaliacaoPre1> transformToModel(List<br.com.spd.domain.AvaliacaoPre1> list) {
		List<AvaliacaoPre1> models = new ArrayList<AvaliacaoPre1>();
		for(br.com.spd.domain.AvaliacaoPre1 tipo : list) {
			models.add(transformToModel(tipo));
		}
		return models;
	}
	
	private Aluno findAluno(Long codPessoa) {
		return alunoRepository.findOne(codPessoa);
	}

}
