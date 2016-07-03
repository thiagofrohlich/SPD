package br.com.spd.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spd.domain.Aluno;

@Repository
public interface AlunoRepository extends PagingAndSortingRepository<Aluno, Long> {

	@EntityGraph(value = "Aluno.turmas", type = EntityGraphType.LOAD)
	List<Aluno> findByNomeLikeIgnoreCaseOrderByTurmaAlunosIdAnoDesc(String nome);

}
