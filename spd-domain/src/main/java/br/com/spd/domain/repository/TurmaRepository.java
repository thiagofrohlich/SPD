package br.com.spd.domain.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spd.domain.Turma;

@Repository
public interface TurmaRepository extends PagingAndSortingRepository<Turma, Long> {

	List<Turma> findByDescricaoLike(String descricao);

}
