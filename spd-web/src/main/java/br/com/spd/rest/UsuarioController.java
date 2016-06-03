package br.com.spd.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.spd.PageSize;
import br.com.spd.domain.Usuario;
import br.com.spd.domain.repository.UsuarioRepository;
import br.com.spd.exception.TransformerException;
import br.com.spd.transformer.impl.GenericTransformer;
import br.com.spd.wrapper.UsuarioWrapper;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final UsuarioRepository usuarioRepository;
	private final GenericTransformer transformer;

	@Autowired
	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
		this.transformer = new GenericTransformer();
	}
	
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public UsuarioWrapper getAll() throws TransformerException {
		List<Usuario> result = (List<Usuario>) usuarioRepository.findAll();
		UsuarioWrapper wrapper = new UsuarioWrapper();
		wrapper.setList(new ArrayList<br.com.spd.model.Usuario>(PageSize.DEFAULT));
		
		for(Usuario usuario : result) {
			br.com.spd.model.Usuario o = new br.com.spd.model.Usuario();
			transformer.transform(usuario, o);
			wrapper.getList().add(o);
		}
		
		return wrapper;
	}
	
	@ResponseBody
	@RequestMapping(value="/page/{page}", method=RequestMethod.GET)
	public UsuarioWrapper getAll(@PathVariable Integer page) throws TransformerException {
		Pageable pageRequest = new PageRequest(page, PageSize.DEFAULT);
		Page<Usuario> result = usuarioRepository.findAll(pageRequest);
		UsuarioWrapper wrapper = new UsuarioWrapper(result);
		wrapper.setList(new ArrayList<br.com.spd.model.Usuario>(PageSize.DEFAULT));
		
		for(Usuario usuario : result) {
			br.com.spd.model.Usuario p = new br.com.spd.model.Usuario();
			transformer.transform(usuario, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public br.com.spd.model.Usuario getOne(@PathVariable final Long id) throws TransformerException {
		Usuario result = usuarioRepository.findOne(id);
		br.com.spd.model.Usuario model = new br.com.spd.model.Usuario();
		transformer.transform(result, model);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/login/{login}", method=RequestMethod.GET)
	public br.com.spd.model.Usuario getByLogin(@PathVariable String login) throws TransformerException {
		Usuario result = usuarioRepository.findByLogin(login);
		br.com.spd.model.Usuario usuario = new br.com.spd.model.Usuario();
		transformer.transform(result, usuario);
		return usuario;
	}
	
	@ResponseBody
	@RequestMapping(value="/loginlike/{login}", method=RequestMethod.GET)
	public UsuarioWrapper getByLoginLike(@PathVariable String login) throws TransformerException {
		List<Usuario> result = usuarioRepository.findByLoginLike("%"+login+"%");
		UsuarioWrapper wrapper = new UsuarioWrapper();
		wrapper.setList(new ArrayList<br.com.spd.model.Usuario>(PageSize.DEFAULT));
		
		for(Usuario usuario : result) {
			br.com.spd.model.Usuario o = new br.com.spd.model.Usuario();
			transformer.transform(usuario, o);
			wrapper.getList().add(o);
		}
		
		return wrapper;
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public br.com.spd.model.Usuario create(@RequestBody br.com.spd.model.Usuario usuario) throws TransformerException {
		return saveOrUpdate(usuario);
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public br.com.spd.model.Usuario update(@RequestBody br.com.spd.model.Usuario usuario) throws TransformerException {
		return saveOrUpdate(usuario);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable final Long id) {
		usuarioRepository.delete(id);
		return usuarioRepository.findOne(id) == null;
	}
	
	private br.com.spd.model.Usuario saveOrUpdate(final br.com.spd.model.Usuario usuario)
			throws TransformerException {
		Usuario p = new Usuario();
		transformer.transform(usuario, p);
		p = usuarioRepository.save(p);
		br.com.spd.model.Usuario model = new br.com.spd.model.Usuario();
		transformer.transform(p, model);
		return model;
	}

}
