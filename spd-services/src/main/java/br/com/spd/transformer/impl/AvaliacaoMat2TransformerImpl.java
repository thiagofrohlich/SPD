package br.com.spd.transformer.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spd.domain.Aluno;
import br.com.spd.domain.repository.AlunoRepository;
import br.com.spd.model.AvaliacaoMat2;
import br.com.spd.transformer.AlunoTransformer;
import br.com.spd.transformer.AvaliacaoMat2Transformer;

@Service
public class AvaliacaoMat2TransformerImpl implements AvaliacaoMat2Transformer {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private AlunoTransformer alunoTransformer;
	
	@Override
	public br.com.spd.domain.AvaliacaoMat2 transformToDomain(AvaliacaoMat2 model) {
		br.com.spd.domain.AvaliacaoMat2 domain = new br.com.spd.domain.AvaliacaoMat2();
		if(model.getCodavaliacao() != null) {
			domain.setCodavaliacao(model.getCodavaliacao());
			domain.setTrimestre(model.getTrimestre());
		}
		
		domain.setArtCorpo(model.getArtCorpo());
		domain.setArtCria(model.getArtCria());
		domain.setArtMateriais(model.getArtMateriais());
		domain.setLingDiferencia(model.getLingDiferencia());
		domain.setLingExpressa(model.getLingExpressa());
		domain.setLingNarra(model.getLingNarra());
		domain.setLingOuve(model.getLingOuve());
		domain.setLingReconhece(model.getLingReconhece());
		domain.setLingRegistra(model.getLingRegistra());
		domain.setLingRepete(model.getLingRepete());
		domain.setLingVogais(model.getLingVogais());
		domain.setMatAgrupa(model.getMatAgrupa());
		domain.setMatCompara(model.getMatCompara());
		domain.setMatContagem(model.getMatContagem());
		domain.setMatElementos(model.getMatElementos());
		domain.setMatFormasGeometricas(model.getMatFormasGeometricas());
		domain.setMatTempo(model.getMatTempo());
		domain.setNatCorpo(model.getNatCorpo());
		domain.setNatEspecies(model.getNatEspecies());
		domain.setNatFamilia(model.getNatFamilia());
		domain.setNatMusicas(model.getNatMusicas());
		domain.setNatPercepcao(model.getNatPercepcao());
		domain.setNatSentimento(model.getNatSentimento());
		domain.setSocAuxilio(model.getSocAuxilio());
		domain.setSocCuida(model.getSocCuida());
		domain.setSocExpressa(model.getSocExpressa());
		domain.setSocExpressoesCorporais(model.getSocExpressoesCorporais());
		domain.setSocInteresse(model.getSocInteresse());
		domain.setSocRelaciona(model.getSocRelaciona());
		domain.setSocRespeita(model.getSocRespeita());
		
		domain.setAluno(findAluno(model.getAluno().getMatricula()));
		
		return domain;
	}

	@Override
	public AvaliacaoMat2 transformToModel(br.com.spd.domain.AvaliacaoMat2 avaliacaoMat2) {

		AvaliacaoMat2 model = new AvaliacaoMat2();
		if(avaliacaoMat2 != null) {
			model = new AvaliacaoMat2();
			model.setCodavaliacao(avaliacaoMat2.getCodavaliacao());
			
			model.setArtCorpo(avaliacaoMat2.getArtCorpo());
			model.setArtCria(avaliacaoMat2.getArtCria());
			model.setArtMateriais(avaliacaoMat2.getArtMateriais());
			model.setLingDiferencia(avaliacaoMat2.getLingDiferencia());
			model.setLingExpressa(avaliacaoMat2.getLingExpressa());
			model.setLingNarra(avaliacaoMat2.getLingNarra());
			model.setLingOuve(avaliacaoMat2.getLingOuve());
			model.setLingReconhece(avaliacaoMat2.getLingReconhece());
			model.setLingRegistra(avaliacaoMat2.getLingRegistra());
			model.setLingRepete(avaliacaoMat2.getLingRepete());
			model.setLingVogais(avaliacaoMat2.getLingVogais());
			model.setMatAgrupa(avaliacaoMat2.getMatAgrupa());
			model.setMatCompara(avaliacaoMat2.getMatCompara());
			model.setMatContagem(avaliacaoMat2.getMatContagem());
			model.setMatElementos(avaliacaoMat2.getMatElementos());
			model.setMatFormasGeometricas(avaliacaoMat2.getMatFormasGeometricas());
			model.setMatTempo(avaliacaoMat2.getMatTempo());
			model.setNatCorpo(avaliacaoMat2.getNatCorpo());
			model.setNatEspecies(avaliacaoMat2.getNatEspecies());
			model.setNatFamilia(avaliacaoMat2.getNatFamilia());
			model.setNatMusicas(avaliacaoMat2.getNatMusicas());
			model.setNatPercepcao(avaliacaoMat2.getNatPercepcao());
			model.setNatSentimento(avaliacaoMat2.getNatSentimento());
			model.setSocAuxilio(avaliacaoMat2.getSocAuxilio());
			model.setSocCuida(avaliacaoMat2.getSocCuida());
			model.setSocExpressa(avaliacaoMat2.getSocExpressa());
			model.setSocExpressoesCorporais(avaliacaoMat2.getSocExpressoesCorporais());
			model.setSocInteresse(avaliacaoMat2.getSocInteresse());
			model.setSocRelaciona(avaliacaoMat2.getSocRelaciona());
			model.setSocRespeita(avaliacaoMat2.getSocRespeita());
			
			model.setAluno(alunoTransformer.transformToModel(avaliacaoMat2.getAluno()));
		}

		return model;
	}
	
	@Override
	public List<AvaliacaoMat2> transformToModel(List<br.com.spd.domain.AvaliacaoMat2> list) {
		List<AvaliacaoMat2> models = new ArrayList<AvaliacaoMat2>();
		for(br.com.spd.domain.AvaliacaoMat2 tipo : list) {
			models.add(transformToModel(tipo));
		}
		return models;
	}
	
	private Aluno findAluno(Long codPessoa) {
		return alunoRepository.findOne(codPessoa);
	}

}
