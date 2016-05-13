package br.com.spd.domain.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spd.domain.Professor;

@Repository
public interface ProfessorRepository extends PagingAndSortingRepository<Professor, Long> {

	Professor findByPessoaCpf(String cpf);
	
	List<Professor> findByPessoaNomeLike(String nome);
	
}
