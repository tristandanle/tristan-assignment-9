package com.coderscampus.assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.repository.RecipeRepository;

@Service
public class FileRecipesService {
	
	@Autowired
	private RecipeRepository repo;  // repository for recipes
	
	public Iterable<CSVRecord> readFiles (String fileName) throws IOException {
//		String[] HEADERS = { "Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", "Preparation Minutes",
//		"Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan",
//		"Vegetarian" };		
		Reader in = new FileReader(fileName);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(',')
				.withHeader(/* HEADERS */) 
				.withEscape('\\')
				.withIgnoreSurroundingSpaces()
				.parse(in);
		return records;
	}
	
	public List<Recipe> listRecipes() throws IOException {
		final String fileName = "recipes.txt";
		try {
			Iterable<CSVRecord> recipesRecords = readFiles(fileName);

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
