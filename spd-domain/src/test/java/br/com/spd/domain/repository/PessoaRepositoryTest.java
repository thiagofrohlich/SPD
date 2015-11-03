package br.com.spd.domain.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.spd.domain.Pessoa;
import br.com.spd.support.SpringTestSupport;

public class PessoaRepositoryTest extends SpringTestSupport {

	@Autowired
	private PessoaRepository repository;

	@Test
	public void test() {
		Pessoa pessoa = new Pessoa();
		pessoa.setCodpessoa(1l);

		Pessoa savedPessoa = repository.save(pessoa);

		assertEquals(savedPessoa.getCodpessoa(), pessoa.getCodpessoa());
	}

}
