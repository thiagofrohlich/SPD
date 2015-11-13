package br.com.spd.domain.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.spd.domain.Ocorrencia;
import br.com.spd.support.SpringTestSupport;

public class OcorrenciaRepositoryTest extends SpringTestSupport {

	@Autowired
	private OcorrenciaRepository repository;

	@Test
	public void test() {
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setIdocorrencia(1l);

		Ocorrencia savedOcorrencia = repository.save(ocorrencia);

		assertEquals(savedOcorrencia.getIdocorrencia(), ocorrencia.getIdocorrencia());
	}

}
