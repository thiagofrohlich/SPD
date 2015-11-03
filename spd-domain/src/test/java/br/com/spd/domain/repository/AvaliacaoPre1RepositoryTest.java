package br.com.spd.domain.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.spd.domain.AvaliacaoPre1;
import br.com.spd.support.SpringTestSupport;

public class AvaliacaoPre1RepositoryTest extends SpringTestSupport {

	@Autowired
	private AvaliacaoPre1Repository repository;

	@Test
	public void test() {
		AvaliacaoPre1 avaliacao = new AvaliacaoPre1();
		avaliacao.setCodavaliacao(1l);

		AvaliacaoPre1 savedAvaliacao = repository.save(avaliacao);

		assertEquals(savedAvaliacao.getCodavaliacao(), avaliacao.getCodavaliacao());
	}

}
