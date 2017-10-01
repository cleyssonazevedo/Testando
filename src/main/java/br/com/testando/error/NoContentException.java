package br.com.testando.error;

public class NoContentException extends Exception {
	private static final long serialVersionUID = -8003248648831958246L;
	private final String id;
	
	public NoContentException() {
		super();
		this.id = null;
	}
	
	public NoContentException(String id) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
}
