package tn.esprit.rh.achat.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import tn.esprit.rh.achat.dto.CategorieDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;

public class CategorieConverter {

	
	public CategorieDTO convertEntityToDto(CategorieProduit c) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(c, CategorieDTO.class);   
    }
	
	public List<CategorieDTO> convertEntitiesToDtos(List<CategorieProduit> categories) {
		List<CategorieDTO> allCategorieDTO = new ArrayList<CategorieDTO>();
		for (CategorieProduit c :categories ) {
			allCategorieDTO.add(convertEntityToDto(c));
		}
        return allCategorieDTO;
    }
	
	
	 public CategorieProduit convertDtoToEntity(CategorieDTO catgDto) {
	        ModelMapper modelMapper = new ModelMapper();
	        return  modelMapper.map(catgDto, CategorieProduit.class);
	    }
}

