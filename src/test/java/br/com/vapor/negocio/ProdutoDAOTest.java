package br.com.vapor.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.vapor.base.ProdutoDAO;
import br.com.vapor.modelo.EnumTipoProduto;
import br.com.vapor.modelo.Produto;
import lombok.Cleanup;

public class ProdutoDAOTest {
	
	@BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

  @Test
  public void example() {
  }
    
//  @Test
  public void mainTest() {
	  
	  @Cleanup
      final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("databaseDefault");

      @Cleanup
      final EntityManager entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
//
      Produto prod = new Produto();    
      ProdutoDAO dao = new ProdutoDAO(entityManager);
//      
//      prod.setSrcImagem("tmp/img-286x215-1.jpg");
//      prod.setSrcImagemModal("tmp/img-640x480-1.jpg");
//      prod.setTitulo("Produto 01");
//      prod.setDescritivo("Descritivo 01");
//      prod.setTipo(EnumTipoProduto.PRODUTO_DESTAQUE.getTipo());
//      dao.insert(prod);      
////      
//      entityManager.getTransaction().commit();
  }
  
}
