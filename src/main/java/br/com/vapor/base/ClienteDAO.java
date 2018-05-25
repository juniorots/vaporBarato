package br.com.vapor.base;

import br.com.vapor.framework.persistence.DaoJpa2;
import br.com.vapor.modelo.Cliente;
import javax.persistence.EntityManager;

/**
 *
 * @author Jose Alves
 */
public class ClienteDAO extends DaoJpa2<Cliente>{

    public ClienteDAO(EntityManager entityManager) {
        super(Cliente.class, entityManager);
    }
    
}
