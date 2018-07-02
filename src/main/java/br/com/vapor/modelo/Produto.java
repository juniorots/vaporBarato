package br.com.vapor.modelo;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import br.com.vapor.framework.persistence.DomainObject;

@Entity 
public class Produto extends DomainObject {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String srcImagem;
	
	private String srcImagemModal;
	
	@NotNull
	private String titulo;
	
	private String subTitulo;
	
	private String urlVideo;
	
	private Boolean contemVideo;
	
	private String descritivo;
	
	@NotNull
	private Integer tipo;
	
	private Double preco;
	
	private String idModal;
	
	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public Boolean getContemVideo() {
		return contemVideo;
	}

	public void setContemVideo(Boolean contemVideo) {
		this.contemVideo = contemVideo;
	}

	public String getIdModal() {
		return idModal;
	}

	public void setIdModal(String idModal) {
		this.idModal = idModal;
	}

	public String getSrcImagemModal() {
		return srcImagemModal;
	}

	public void setSrcImagemModal(String srcImagemModal) {
		this.srcImagemModal = srcImagemModal;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getSrcImagem() {
		return srcImagem;
	}

	public void setSrcImagem(String srcImagem) {
		this.srcImagem = srcImagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescritivo() {
		return descritivo;
	}

	public void setDescritivo(String descritivo) {
		this.descritivo = descritivo;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}	
	
}
