package br.com.spd.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spd.domain.AvaliacaoMat2;

@Repository
public interface AvaliacaoMat2Repository extends PagingAndSortingRepository<AvaliacaoMat2, Long> {

}
