package com.rajat.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rajat.model.Category;
import com.rajat.repository.CatergoryRepository;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CatergoryRepository catergoryRepository;	
	
	public List<Category> getCatList(){		
		return catergoryRepository.findAll();
	}
	
	public Optional<Category> getCat(Long id) {
		return catergoryRepository.findById(id);		
	}	
	
	public Category addCat(Category entity) {
		return catergoryRepository.save(entity);
	}
	
	public void deleteCat(Long id) {
		catergoryRepository.deleteById(id);
	}
}
