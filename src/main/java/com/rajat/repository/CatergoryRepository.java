package com.rajat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rajat.model.Category;

public interface CatergoryRepository extends JpaRepository<Category, Long>{
	Category findByName(String name);
}