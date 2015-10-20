package br.com.spd.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spd.domain.Pessoa;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {

}
