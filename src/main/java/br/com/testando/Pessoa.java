package br.com.testando;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pessoa {
	@JsonIgnore
	public static Long generateID = (long)1;
	
	private Long id;
	private String nome;
	private String sobrenome;

	public Pessoa() {
		// TODO Auto-generated constructor stub
		id = Pessoa.generateID;
		nome = "Cleysson";
		sobrenome = "Azevedo";
		
		Pessoa.generateID++;
	}
	
	public Pessoa(@JsonProperty(required = true) @NotNull String nome, @JsonProperty(required = true) @NotNull String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.id = Pessoa.generateID;
		Pessoa.generateID++;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

}
