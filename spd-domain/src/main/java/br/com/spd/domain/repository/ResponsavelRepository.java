package br.com.spd.domain.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spd.domain.Responsavel;

@Repository
public interface ResponsavelRepository extends PagingAndSortingRepository<Responsavel, Long> {

	Responsavel findByPessoaCpf(String cpf);
	
	List<Responsavel> findByPessoaNomeLike(String nome);
	
}
