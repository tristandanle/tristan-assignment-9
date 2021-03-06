package com.coderscampus.assignment9.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.coderscampus.assignment9.domain.Recipe;

@Repository
public class RecipeRepository {
	File file = new File("recipes.txt");
	List<Recipe> recipes = new ArrayList<>((int)file.length());
	
	public List<Recipe> getRecipes() {
		return recipes;
	}
}
