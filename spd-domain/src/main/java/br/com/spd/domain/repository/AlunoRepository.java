package br.com.spd.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spd.domain.Aluno;

@Repository
public interface AlunoRepository extends PagingAndSortingRepository<Aluno, Long> {

}
