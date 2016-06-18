package br.com.spd.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spd.domain.TurmaAluno;
import br.com.spd.domain.TurmaAlunoPK;

@Repository
public interface TurmaAlunoRepository extends PagingAndSortingRepository<TurmaAluno, TurmaAlunoPK> {

	@Query("select ta from TurmaAluno ta where ta.id.turmaId = ?1 and ta.id.ano = ?2")
	List<TurmaAluno> findByTurmaAndAno(Long turmaId, String ano);
	
}
