package br.com.spd.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spd.domain.Usuario;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

	@Query("select count(u) from Usuario u where u.login = ?1 and u.senha = ?2")
	long exists(String login, String senha);
	
	Usuario findByLogin(String login);
	
	List<Usuario> findByLoginLikeIgnoreCase(String descricao);

}
