package br.com.vapor.negocio;

import java.io.Serializable;

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
import br.com.vapor.util.Util;
import lombok.Cleanup;

public class ProdutoDAOTest implements Serializable {
	
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

    /**
     * Util na verificacao de produto ja existente na base de dados
     * @return
     */
    public Produto contidoBase(Produto produto) {
    	@Cleanup
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("databaseDefault");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
                
        ProdutoDAO dao = new ProdutoDAO(entityManager);
        if (!Util.isEmpty(dao.findByStringField("srcImagem", produto.getSrcImagem(), true, 0, 1))) {
        	return dao.findByStringField("srcImagem", produto.getSrcImagem(), true, 0, 1).get(0);
        } else 
        	return null;
    }
    
    /**
     * Atualizando produto
     */
    public void atualizarProduto(Produto produto) {
		@Cleanup
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("databaseDefault");
        
		@Cleanup
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        ProdutoDAO dao = new ProdutoDAO(entityManager);
        dao.update(produto);
        entityManager.getTransaction().commit();
	}
    
    /**
     * Inserindo produto na base
     */
    public void inserirProduto(Produto produto) {
		@Cleanup
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("databaseDefault");
        
		@Cleanup
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        ProdutoDAO dao = new ProdutoDAO(entityManager);
        dao.insert(produto);
        entityManager.getTransaction().commit();
	}
    
  @Test
  public void mainTest() {
	  
	  @Cleanup
      final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("databaseDefault");

      @Cleanup
      final EntityManager entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();

      ProdutoDAO dao = new ProdutoDAO(entityManager);
      
      Produto prod;
      Produto tmp;
      for (int i = 1; i <= 12; i++) {
    	  prod = new Produto();
    	  if (i == 9) {
    		  prod.setSrcImagem("img/portfolio/"+i+".gif");
    	  } else {
    		  prod.setSrcImagem("img/portfolio/"+i+".jpg");
    	  }
    	  prod.setIdModal("portfolioModal"+i);
	      prod.setTitulo("Texto Titulo "+i);
	      prod.setSubTitulo("SubTitulo Descritivo "+i);
	      prod.setTipo(EnumTipoProduto.PRODUTO_DESTAQUE.getTipo());
	      prod.setContemVideo(true);
	      prod.setUrlVideo("https://player.vimeo.com/video/64254212");
	      prod.setDescritivo("We have created a new theme that will help designers, "
	      		+ "developers and companies create simple and beautiful business "
	      		+ "or personal website quickly and easily.");
	      
	      tmp = contidoBase(prod);
	      if (Util.isEmpty(tmp)) {
	    	  inserirProduto(prod);
	      } else {
	    	  prod.setId(tmp.getId());
	    	  atualizarProduto(prod);
	      }
      }
      
      entityManager.getTransaction().commit();
  }
  
}
