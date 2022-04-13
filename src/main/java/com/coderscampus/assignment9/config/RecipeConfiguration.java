package com.coderscampus.assignment9.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.coderscampus.assignment9.service.FileService;

@Configuration
@ComponentScan("com.coderscampus.assignment9")
public class RecipeConfiguration {
	
	
	// passing the key which is set in application.properties
	@Value("${superrecipe.cookingMinutes}")
	private Integer superrecipeCookingMinutes;
	@Value("${superrecipe.dairyFree}")
	private Boolean superrecipeDairyFree;
	@Value("${superrecipe.glutenFree}")
	private Boolean superrecipeGlutenFree;
	@Value("${superrecipe.instructions}")
	private String superrecipeInstructions;
	@Value("${superrecipe.preparationMinutes}")
	private Double superrecipePreparationMinutes;
	@Value("${superrecipe.pricePerServing}")
	private Double superrecipePricePerServing;
	@Value("${superrecipe.readyInMinutes}")
	private Integer superrecipeReadyInMinutes;
	@Value("${superrecipe.servings}")
	private Integer superrecipeServings;
	@Value("${superrecipe.spoonacularScore}")
	private Double superrecipeSpoonacularScore;
	@Value("${superrecipe.title}")
	private String superrecipeTitle;
	@Value("${superrecipe.vegan}")
	private Boolean superrecipeVegan;
	@Value("${superrecipe.vegetarian}")
	private Boolean superrecipeVegetarian;
	
	
	
// getting the value from that key which is set in application.properties
	@Bean
	public Integer getCookingMinutes() {
		return superrecipeCookingMinutes;
	}
	
	@Bean
	public Boolean getdairyFree() {
		return superrecipeDairyFree;
	}
	
	@Bean
	public Boolean getGlutenFree() {
		return superrecipeGlutenFree;
	}
	
	@Bean
	public String getInstructions() {
		return superrecipeInstructions;
	}
	
	@Bean
	public Double getPreparationMinutes() {
		return superrecipePreparationMinutes;
	}
	
	@Bean
	public Double getpricePerServing() {
		return superrecipePricePerServing;
	}
	
	@Bean
	public Integer getreadyInMinutes() {
		return superrecipeReadyInMinutes;
	}
	
	@Bean
	public Integer getServings() {
		return superrecipeServings;
	}
	
	
	@Bean
	public Double getSpoonacularScore() {
		return superrecipeSpoonacularScore;
	}
	
	@Bean
	public String getTitle() {
		return  superrecipeTitle;
	}
	
	@Bean
	public Boolean getVegan() {
		return superrecipeVegan;
	}
	
	@Bean
	public Boolean getVegetarian() {
		return superrecipeVegetarian;
	}
	
	
	
	
	
	
	
//	@Bean
//	public Recipe recipe() {
//
//		Recipe recipe = new Recipe();
//		recipe.setCookingMinutes(cookingMinutes);
//		recipe.setDairyFree(dairyFree);
//		recipe.setGlutenFree(glutenFree); 
//		 recipe.setInstructions(instructions);
//		 recipe.setPreparationMinutes(preparationMinutes); 
//		recipe.setPricePerServing(pricePerServing);
//		 recipe.setReadyInMinutes(readyInMinutes);
//		 recipe.setServings(servings); 
//		 recipe.setSpoonacularScore(spoonacularScore);
//		 recipe.setTitle(title); 
//		 recipe.setVegan(vegan);
//		recipe.setVegetarian(vegetarian);
//
//		return recipe;
//
//	}
	
//	@Bean
//	public List<Recipe> recipe (List<CSVRecord> records) {
//		List<Recipe> recipes = new ArrayList<Recipe>();
//		for (CSVRecord record : records) {
//			Integer cookingMinutes = Integer.parseInt(record.get(0));
//			Boolean dairyFree =  Boolean.parseBoolean(record.get(1));
//			Boolean glutenFree = Boolean.parseBoolean(record.get(2));
//			String instructions = record.get(3);
//			Double preparationMinutes = Double.parseDouble(record.get(4));
//			Double pricePerServing = Double.parseDouble(record.get(5));
//			Integer readyInMinutes = Integer.parseInt(record.get(6));
//			Integer servings = Integer.parseInt(record.get(7));
//			Double spoonacularScore = Double.parseDouble(record.get(8));
//			String title =  record.get(9);
//			Boolean vegan = Boolean.parseBoolean(record.get(10));
//			Boolean vegetarian = Boolean.parseBoolean(record.get(11));
//			
//			Recipe recipe = new Recipe(  cookingMinutes, 
//										 dairyFree, 
//										 glutenFree, 
//										 instructions, 
//										 preparationMinutes, 
//										 pricePerServing, 
//										 readyInMinutes, 
//										 servings, 
//										 spoonacularScore,
//										 title, 
//										 vegan, 
//										 vegetarian);
//			recipes.add(recipe);				             
//		}	
//		return recipes;
//	}

} // end class