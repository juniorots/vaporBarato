package br.com.vapor.modelo;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import br.com.vapor.framework.persistence.DomainObject;

@Entity
public class Cliente extends DomainObject {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String email;
	
	private String senha;
	
	private String telefone;
	    
	@Transient
	private String confirmaSenha;
	
	@Transient
	private String mensagem;

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
}
