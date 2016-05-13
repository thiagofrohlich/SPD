package br.com.spd.domain.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spd.domain.TipoOcorrencia;

@Repository
public interface TipoOcorrenciaRepository extends PagingAndSortingRepository<TipoOcorrencia, Long> {

	List<TipoOcorrencia> findByDescricaoLike(String descricao);

}
