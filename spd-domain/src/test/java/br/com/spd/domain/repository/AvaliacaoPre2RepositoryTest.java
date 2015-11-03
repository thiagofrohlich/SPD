package br.com.spd.domain.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.spd.domain.AvaliacaoPre2;
import br.com.spd.support.SpringTestSupport;

public class AvaliacaoPre2RepositoryTest extends SpringTestSupport {

	@Autowired
	private AvaliacaoPre2Repository repository;

	@Test
	public void test() {
		AvaliacaoPre2 avaliacao = new AvaliacaoPre2();
		avaliacao.setCodavaliacao(1l);

		AvaliacaoPre2 savedAvaliacao = repository.save(avaliacao);

		assertEquals(savedAvaliacao.getCodavaliacao(), avaliacao.getCodavaliacao());
	}

}
