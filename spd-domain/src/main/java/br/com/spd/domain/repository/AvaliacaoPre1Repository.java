package br.com.spd.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spd.domain.AvaliacaoPre1;

@Repository
public interface AvaliacaoPre1Repository extends PagingAndSortingRepository<AvaliacaoPre1, Long> {

}
