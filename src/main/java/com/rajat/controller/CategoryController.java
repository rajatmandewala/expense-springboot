package com.rajat.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rajat.model.Category;
import com.rajat.service.CategoryService;

@RestController
@RequestMapping(value = "/api")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private Category cat;

	@GetMapping(value = "/cat")
	public List<Category> getAllCat() {
		return categoryService.getCatList();
	}

	@GetMapping(value = "/cat/{id}")
	ResponseEntity<?> getCat(@PathVariable Long id) {
		Optional<Category> category = categoryService.getCat(id);
		return category.map(response -> ResponseEntity.ok(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping(value = "cat")
	ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException {
		cat = categoryService.addCat(category);		
		return ResponseEntity.created(new URI("/api/cat/" + cat.getId())).body(cat);
	}
	
	@PutMapping(value="cat")
	ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category){
		cat=categoryService.addCat(category);
		return ResponseEntity.ok().body(cat);		
	}
	
	@DeleteMapping(value="/cat/{id}")
	ResponseEntity<?> deleteCategory(@PathVariable Long id){
		categoryService.deleteCat(id);
		return ResponseEntity.ok().build();
	}
}
