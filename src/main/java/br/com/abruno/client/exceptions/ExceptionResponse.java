package br.com.abruno.client.exceptions;

import java.io.Serializable;

public class ExceptionResponse implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	private String mensagem;
	private boolean status;
	
	
	public ExceptionResponse(String mensagem, boolean status) {
		super();
		this.mensagem = mensagem;
		this.status = status;
	}


	public String getMensagem() {
		return mensagem;
	}


	public boolean getDetalhes() {
		return status;
	}
	
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public ExceptionResponse() {
        super();
    }	
	

}
