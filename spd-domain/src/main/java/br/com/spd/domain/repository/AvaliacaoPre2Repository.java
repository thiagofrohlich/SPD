package br.com.spd.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spd.domain.AvaliacaoPre2;

@Repository
public interface AvaliacaoPre2Repository extends PagingAndSortingRepository<AvaliacaoPre2, Long> {

}
