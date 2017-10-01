package br.com.testando;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class Controller {

	@PostMapping
	public Pessoa setPessoa(@RequestBody Pessoa pessoa) {
		pessoa.setId(Pessoa.generateID);
		Pessoa.generateID++;
		return pessoa;
	}
	
	@GetMapping
	public Pessoa getPessoa() {
		return new Pessoa();
	}
}
