package br.com.vapor.base;

import javax.persistence.EntityManager;

import br.com.vapor.framework.persistence.DaoJpa2;
import br.com.vapor.modelo.Produto;

public class ProdutoDAO extends DaoJpa2<Produto>{

	public ProdutoDAO(EntityManager entityManager) {
        super(Produto.class, entityManager);
    }
}
