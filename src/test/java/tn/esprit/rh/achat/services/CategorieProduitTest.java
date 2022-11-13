package tn.esprit.rh.achat.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.CategorieProduit;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategorieProduitTest {
	@Autowired
	ICategorieProduitService cp;
	
	@Test
    @Order (1)
    public void testRetreiveAllCategorie() {
		
		List<CategorieProduit> listCategories = cp.retrieveAllCategorieProduits();
        Assertions.assertEquals(0, listCategories.size());
	}
	

}
