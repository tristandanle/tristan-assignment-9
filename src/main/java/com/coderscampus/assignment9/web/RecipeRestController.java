package com.coderscampus.assignment9.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.repository.RecipeRepository;
import com.coderscampus.assignment9.service.FileRecipesService;

@RestController   // Get raw data 
public class RecipeRestController {
// Instruction: Once ingested the recipe.txt file and stored the resulting 
// POJOs into a Collection,next task is to create “endpoints” 
// inside of a RestController that will filter this data

	@Autowired
	private FileRecipesService recipesService;

	@GetMapping("/gluten-free")
	public List<Recipe> listGlutenFree() throws IOException {
		// The “gluten-free” endpoint will only return a subset of
		// the full Collection where glutenFree is true
		// Method of stream()
	   List<Recipe> subsetGF = recipesService.listRecipes().stream()
	   .filter(Recipe::getGlutenFree)
       .collect(Collectors.toList());
		return subsetGF;
		}
	

	@GetMapping("/vegan")
	public List<Recipe> listVegan() throws IOException {
		// The “vegan” endpoint will only return a subset of
		// the full Collection where vegan is true
		RecipeRepository repo = new RecipeRepository();
		
		List<Recipe> subsetVegan = new ArrayList<Recipe>();
		// Method of for loop
		for(Recipe r : recipesService.listRecipes()) {
			if (r.getVegan() == true) {
				subsetVegan.add(r);
			}
		}
		
		return subsetVegan;
		
	}
	
	
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> listVeganGlutenFree() throws IOException {
	// The “vegan-and-gluten-free” endpoint will only return a subset 
	//  of the full Collection where glutenFree is true and vegan is true
		//Filter 1
		Predicate<Recipe> isGluten = r -> r.getGlutenFree().equals(true);
		//Filter 2
		Predicate<Recipe> isVegan = r -> r.getVegan().equals(true);
		
		// Method of Predicate's filter
		List<Recipe> listVG = recipesService.listRecipes().stream()
		.filter(isGluten.and(isVegan))
		.collect(Collectors.toList());
		
		return listVG;
	}
	

	@GetMapping("/vegetarian")
	public List<Recipe> getVegetarian() throws IOException {
		// The “vegetarian” endpoint will only return a subset of the 
		// full Collection where vegetarian is true 
		Predicate<Recipe> isVegetarian = r -> r.getVegetarian().equals(true);
		
	    return recipesService.listRecipes().stream()
	    .filter(isVegetarian)
	    .collect(Collectors.toList());
		}
	
	
	@GetMapping("/all-recipes")
	public List<Recipe> getAllRecipes() throws IOException {
		// The “all-recipes” endpoint will not filter the data at all 
		// and should return the full Collection.
		
		// return recipesService.listRecipes().stream()
		//		.collect(Collectors.toList());
		
		return recipesService.listRecipes();
		
		}

}
