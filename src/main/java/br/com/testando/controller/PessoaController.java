package br.com.testando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testando.dao.IPessoa;
import br.com.testando.error.NoContentException;
import br.com.testando.modelo.Pessoa;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	@Autowired
	private IPessoa pessoaDAO;
	
	@PostMapping
	public void Inserir(@RequestBody @Validated Pessoa pessoa) {
		pessoaDAO.insert(pessoa);
	}
	
	@DeleteMapping("/{id}")
	public void Remover(@PathVariable String id) throws Exception {
		Pessoa pessoa = pessoaDAO.findOne(id);
		if(pessoa != null)
			pessoaDAO.delete(pessoa);
		else
			throw new NoContentException(id);
	}
	
	@GetMapping("/{id}")
	public Pessoa Buscar(@PathVariable String id) throws Exception {
		Pessoa pessoa = pessoaDAO.findOne(id);
		if(pessoa != null)
			return pessoa;
		else
			throw new NoContentException(id);
	}
	
	@GetMapping
	public List<Pessoa> listar() throws Exception {
		List<Pessoa> pessoas = pessoaDAO.findAll();
		if(pessoas != null && pessoas.size() > 0)
			return pessoas;
		else
			throw new NoContentException();
	}
}
