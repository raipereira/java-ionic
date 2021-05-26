package com.casestudy.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.casestudy.model.Category;
import com.casestudy.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Transactional
	@Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categories cat WHERE obj.name LIKE %:name% and cat IN :categories")
	Page<Product> search(@Param("name") String name, @Param("categories")List<Category> categories, Pageable pageRequest);
	
	//Page<Product> findDistinctByNameContainingAndCategoriesIn(String name, List<Category> categories, Pageable pageRequest);
	
	
	

}
