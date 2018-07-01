package br.com.vapor.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.vapor.base.ProdutoDAO;
import br.com.vapor.modelo.EnumTipoProduto;
import br.com.vapor.modelo.Produto;
import lombok.Cleanup;

/**
*
* @author Jose Alves
*/
@ManagedBean
@RequestScoped
public class ProdutoMB implements Serializable {
	private static final long serialVersionUID = 1L;

	private Produto produto = null;
	private Collection<Produto> listaProduto = new ArrayList();
	private Collection<Produto> listaLancamento = new ArrayList();

	public ProdutoMB() {
		/*
         * Trabalhando no conteudo...
         */
        @Cleanup
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("databaseDefault");
        
        @Cleanup
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        ProdutoDAO dao = new ProdutoDAO(entityManager);
        
        for (Produto p : dao.selectAll()) {
    		this.listaProduto.add( p );
        }
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Collection<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(Collection<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public Collection<Produto> getListaLancamento() {
		return listaLancamento;
	}

	public void setListaLancamento(Collection<Produto> listaLancamento) {
		this.listaLancamento = listaLancamento;
	}
	
}