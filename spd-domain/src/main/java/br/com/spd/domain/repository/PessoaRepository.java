package br.com.spd.domain.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spd.domain.Pessoa;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {

	Pessoa findByCpf(String cpf);
	
	List<Pessoa> findByNomeLike(String nome);
	
}
