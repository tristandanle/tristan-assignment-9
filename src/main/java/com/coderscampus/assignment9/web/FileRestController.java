package com.coderscampus.assignment9.web;

import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.repository.RecipeRepository;
import com.coderscampus.assignment9.service.FileRecipesService;

@RestController // return raw data - dependency injection
public class FileRestController {

	@Autowired
	private FileRecipesService fileService;

	@Autowired
	private RecipeRepository repo;

	@GetMapping("/list/recipe")
	public List<Recipe> listRecipes() throws IOException {
		final String fileName = "recipes.txt";
		try {
			Iterable<CSVRecord> recipesRecords = fileService.readFiles(fileName);

			for (CSVRecord record : recipesRecords) {
				Recipe recipe = new Recipe(
						Integer.parseInt(record.get(0)), // column Cooking Minutes
						Boolean.parseBoolean(record.get(1)), // column Dairy Free
						Boolean.parseBoolean(record.get(2)), // column Gluten Free
						record.get(3), // column Instructions
						Double.parseDouble(record.get(4)), // column Preparation Minutes
						Double.parseDouble(record.get(5)), // column Price Per Serving
						Integer.parseInt(record.get(6)), // column Ready In Minutes
						Integer.parseInt(record.get(7)), // column Servings
						Double.parseDouble(record.get(8)), // column Spoonacular Score
						record.get(9), // Title
						Boolean.parseBoolean(record.get(10)), // column Vegan
						Boolean.parseBoolean(record.get(11)) // column Vegetarian
				);

				repo.getRecipes().add(recipe);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return repo.getRecipes();
	}

}
