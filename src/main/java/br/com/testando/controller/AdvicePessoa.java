package br.com.testando.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.testando.error.NoContentException;

@ControllerAdvice
public class AdvicePessoa {
	private static final Logger LOGGER = Logger.getLogger(AdvicePessoa.class);
	
	@ExceptionHandler(NoContentException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void NoContent(NoContentException e) {
		if(e.getID() != null)
			LOGGER.debug("Objeto não encontrado com o ID: " + e.getID());
		else
			LOGGER.debug("Pesquisa retornou nulo!");
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public void Exception(Exception e) {
		LOGGER.fatal("Fatal Error", e);
	}
	
}
