package br.com.spd.domain.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.spd.domain.AvaliacaoMat2;
import br.com.spd.support.SpringTestSupport;

public class AvaliacaoMat2RepositoryTest extends SpringTestSupport {

	@Autowired
	private AvaliacaoMat2Repository repository;
	
	@Test
	public void test() {
		AvaliacaoMat2 avaliacao = new AvaliacaoMat2();
		avaliacao.setCodavaliacao(1l);
		
		AvaliacaoMat2 savedAvaliacao = repository.save(avaliacao);
		
		assertEquals(savedAvaliacao.getCodavaliacao(), avaliacao.getCodavaliacao());
	}
	
}
