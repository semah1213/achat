package tn.esprit.rh.achat.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import java.util.Optional;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;


@SpringBootTest(classes =  CategorieProduitTest.class)
@RunWith(MockitoJUnitRunner.class)
public class CategorieProduitTest {
/*	@Autowired
	ICategorieProduitService cp;
	
	@Test
    @Order (1)
    public void testRetreiveAllCategorie() {
		
		List<CategorieProduit> listCategories = cp.retrieveAllCategorieProduits();
        Assertions.assertEquals(0, listCategories.size());
	}*/
	
	@Mock	
	CategorieProduitRepository categorieProduitRepository;
	@InjectMocks
	CategorieProduitServiceImpl categorieProduit;

	CategorieProduit c1 = new CategorieProduit (1L,"abc","homme",null);
	CategorieProduit c2 = new CategorieProduit (2L,"abd","femme",null);

	@Test
	public void testRetrievecategorie() {
	Mockito.when(categorieProduitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(c1));
	CategorieProduit categorie1 = categorieProduit.retrieveCategorieProduit(1L);
	Assertions.assertNotNull(categorie1);
	}

	@Test
	public void createcategorieproduitTest()
	{
		CategorieProduit cat1 = new CategorieProduit(1L,"abc","homme",null);

		categorieProduit.addCategorieProduit(cat1);

		verify(categorieProduitRepository, times(1)).save(cat1);
	}
	@Test
	public void testDeleteStock() {
	    long catid =1L;
	    categorieProduit.deleteCategorieProduit(catid);
	    Assertions.assertNull(categorieProduit.retrieveCategorieProduit(catid));
	}
	

}
