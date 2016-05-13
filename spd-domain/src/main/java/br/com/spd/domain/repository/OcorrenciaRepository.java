package br.com.spd.domain.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spd.domain.Ocorrencia;

@Repository
public interface OcorrenciaRepository extends PagingAndSortingRepository<Ocorrencia, Long> {

	List<Ocorrencia> findByDescricaoLike(String descricao);

}
