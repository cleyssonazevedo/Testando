package br.com.testando.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.testando.modelo.Pessoa;

public interface IPessoa extends MongoRepository<Pessoa, String>{

}
