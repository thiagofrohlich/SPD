package br.com.spd.domain.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.spd.domain.Aluno;
import br.com.spd.support.SpringTestSupport;

public class AlunoRepositoryTest extends SpringTestSupport {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Test
	public void test() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(1l);
		
		Aluno savedAluno = alunoRepository.save(aluno);
		
		assertEquals(savedAluno.getMatricula(), aluno.getMatricula());
	}
	
}
