package tn.esprit.rh.achat.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
	CategorieProduitServiceImpl CategorieProduitServiceImpl;

	CategorieProduit categorieProduit = new CategorieProduit(Long.valueOf(1), "123", "f1", null);

	List<CategorieProduit> listCategorieProduit = new ArrayList<CategorieProduit>() {
		{
			add(new CategorieProduit(Long.valueOf(2), "456", "f2", null));
			add(new CategorieProduit(Long.valueOf(3), "789", "f3", null));
		}
	};
	
	@Test
	public void TestretrieveAllStocks() {

		Mockito.when(categorieProduitRepository.findAll()).thenReturn(listCategorieProduit);
		List<CategorieProduit> list = CategorieProduitServiceImpl.retrieveAllCategorieProduits();
		assertEquals(2, list.size());
		System.out.println("Retrieve all");
	}
	
	@Test
	public void testAddStock() {

		Mockito.when(categorieProduitRepository.save(categorieProduit)).thenReturn(categorieProduit);
		CategorieProduit categorieProduit1 = CategorieProduitServiceImpl.addCategorieProduit(categorieProduit);
		Assertions.assertNotNull(categorieProduit1);
		System.out.println("added !");
	}
	
	@Test
	public void testdeleteStock() {
		CategorieProduit categorieProduit1 = new CategorieProduit(Long.valueOf(4), "741", "f4", null);
		CategorieProduitServiceImpl.deleteCategorieProduit(categorieProduit1.getIdCategorieProduit());
		Mockito.verify(categorieProduitRepository).deleteById(categorieProduit1.getIdCategorieProduit());
		System.out.println("deleted");
	}
	
	@Test
	public void testUpdateStock() {
		categorieProduit.setLibelleCategorie("libelleUpdated");
		Mockito.when(categorieProduitRepository.save(categorieProduit)).thenReturn(categorieProduit);
		CategorieProduit categorieProduit1 = CategorieProduitServiceImpl.updateCategorieProduit(categorieProduit);
		Assertions.assertEquals(categorieProduit.getLibelleCategorie(), categorieProduit1.getLibelleCategorie());
		System.out.println(categorieProduit1);
	}
	
	@Test
	public void testRetrieveStock() {

		Mockito.when(categorieProduitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(categorieProduit));
		CategorieProduit categorieProduit1 = CategorieProduitServiceImpl.retrieveCategorieProduit(Long.valueOf(1));
		Assertions.assertNotNull(categorieProduit1);
		System.out.println("Retrieved !");
	}
	

}
