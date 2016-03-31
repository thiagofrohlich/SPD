package br.com.spd.transformer.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spd.domain.Aluno;
import br.com.spd.domain.repository.AlunoRepository;
import br.com.spd.model.AvaliacaoPre2;
import br.com.spd.transformer.AlunoTransformer;
import br.com.spd.transformer.AvaliacaoPre2Transformer;

@Service
public class AvaliacaoPre2TransformerImpl implements AvaliacaoPre2Transformer {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private AlunoTransformer alunoTransformer;
	
	@Override
	public br.com.spd.domain.AvaliacaoPre2 transformToDomain(AvaliacaoPre2 model) {
		br.com.spd.domain.AvaliacaoPre2 domain = new br.com.spd.domain.AvaliacaoPre2();
		if(model.getCodavaliacao() != null) {
			domain.setCodavaliacao(model.getCodavaliacao());
			domain.setTrimestre(model.getTrimestre());
		}
		
		domain.setArtCria(model.getArtCria());
		domain.setArtExplora(model.getArtExplora());
		domain.setArtParticipa(model.getArtParticipa());
		domain.setLingAlfabetico(model.getLingAlfabetico());
		domain.setLingBrinca(model.getLingBrinca());
		domain.setLingDesenho(model.getLingDesenho());
		domain.setLingEscreve(model.getLingEscreve());
		domain.setLingEspacamento(model.getLingEspacamento());
		domain.setLingOrganiza(model.getLingOuve());
		domain.setLingOuve(model.getLingOuve());
		domain.setLingPreSilabico(model.getLingPreSilabico());
		domain.setLingRelacionaLetras(model.getLingRelacionaLetras());
		domain.setLingSilabico(model.getLingSilabico());
		domain.setLingTentativaLeitura(model.getLingTentativaLeitura());
		domain.setMatContagem(model.getMatContagem());
		domain.setMatContagem(model.getMatDecimais());
		domain.setMatDesenho(model.getMatDesenho());
		domain.setMatQuantidade(model.getMatQuantidade());
		domain.setMatRealizaContagem(model.getMatRealizaContagem());
		domain.setMatSimbolo(model.getMatSimbolo());
		domain.setMatTempo(model.getMatTempo());
		domain.setNatAmbientes(model.getNatAmbientes());
		domain.setNatComunicacao(model.getNatComunicacao());
		domain.setNatHipoteses(model.getNatHipoteses());
		domain.setNatInfluencia(model.getNatInfluencia());
		domain.setNatMusicas(model.getNatMusicas());
		domain.setNatRecursos(model.getNatRecursos());
		domain.setNatTemperatura(model.getNatTemperatura());
		domain.setSocBrinca(model.getSocBrinca());
		domain.setSocCuida(model.getSocCuida());
		domain.setSocExpressa(model.getSocExpressa());
		domain.setSocFrustracao(model.getSocFrustracao());
		domain.setSocIniciativa(model.getSocIniciativa());
		domain.setSocInteresse(model.getSocInteresse());
		domain.setSocOrienta(model.getSocOrienta());
		domain.setSocRaciocinio(model.getSocRaciocinio());
		domain.setSocRelaciona(model.getSocRelaciona());
		
		domain.setAluno(findAluno(model.getAluno().getMatricula()));
		
		return domain;
	}

	@Override
	public AvaliacaoPre2 transformToModel(br.com.spd.domain.AvaliacaoPre2 avaliacaoPre2) {

		AvaliacaoPre2 model = new AvaliacaoPre2();
		if(avaliacaoPre2 != null) {
			model = new AvaliacaoPre2();
			model.setCodavaliacao(avaliacaoPre2.getCodavaliacao());
			
			model.setArtCria(avaliacaoPre2.getArtCria());
			model.setArtExplora(avaliacaoPre2.getArtExplora());
			model.setArtParticipa(avaliacaoPre2.getArtParticipa());
			model.setLingAlfabetico(avaliacaoPre2.getLingAlfabetico());
			model.setLingBrinca(avaliacaoPre2.getLingBrinca());
			model.setLingDesenho(avaliacaoPre2.getLingDesenho());
			model.setLingEscreve(avaliacaoPre2.getLingEscreve());
			model.setLingEspacamento(avaliacaoPre2.getLingEspacamento());
			model.setLingOrganiza(avaliacaoPre2.getLingOuve());
			model.setLingOuve(avaliacaoPre2.getLingOuve());
			model.setLingPreSilabico(avaliacaoPre2.getLingPreSilabico());
			model.setLingRelacionaLetras(avaliacaoPre2.getLingRelacionaLetras());
			model.setLingSilabico(avaliacaoPre2.getLingSilabico());
			model.setLingTentativaLeitura(avaliacaoPre2.getLingTentativaLeitura());
			model.setMatContagem(avaliacaoPre2.getMatContagem());
			model.setMatContagem(avaliacaoPre2.getMatDecimais());
			model.setMatDesenho(avaliacaoPre2.getMatDesenho());
			model.setMatQuantidade(avaliacaoPre2.getMatQuantidade());
			model.setMatRealizaContagem(avaliacaoPre2.getMatRealizaContagem());
			model.setMatSimbolo(avaliacaoPre2.getMatSimbolo());
			model.setMatTempo(avaliacaoPre2.getMatTempo());
			model.setNatAmbientes(avaliacaoPre2.getNatAmbientes());
			model.setNatComunicacao(avaliacaoPre2.getNatComunicacao());
			model.setNatHipoteses(avaliacaoPre2.getNatHipoteses());
			model.setNatInfluencia(avaliacaoPre2.getNatInfluencia());
			model.setNatMusicas(avaliacaoPre2.getNatMusicas());
			model.setNatRecursos(avaliacaoPre2.getNatRecursos());
			model.setNatTemperatura(avaliacaoPre2.getNatTemperatura());
			model.setSocBrinca(avaliacaoPre2.getSocBrinca());
			model.setSocCuida(avaliacaoPre2.getSocCuida());
			model.setSocExpressa(avaliacaoPre2.getSocExpressa());
			model.setSocFrustracao(avaliacaoPre2.getSocFrustracao());
			model.setSocIniciativa(avaliacaoPre2.getSocIniciativa());
			model.setSocInteresse(avaliacaoPre2.getSocInteresse());
			model.setSocOrienta(avaliacaoPre2.getSocOrienta());
			model.setSocRaciocinio(avaliacaoPre2.getSocRaciocinio());
			model.setSocRelaciona(avaliacaoPre2.getSocRelaciona());
			
			model.setAluno(alunoTransformer.transformToModel(avaliacaoPre2.getAluno()));
		}

		return model;
	}
	
	@Override
	public List<AvaliacaoPre2> transformToModel(List<br.com.spd.domain.AvaliacaoPre2> list) {
		List<AvaliacaoPre2> models = new ArrayList<AvaliacaoPre2>();
		for(br.com.spd.domain.AvaliacaoPre2 tipo : list) {
			models.add(transformToModel(tipo));
		}
		return models;
	}
	
	private Aluno findAluno(Long codPessoa) {
		return alunoRepository.findOne(codPessoa);
	}

}
