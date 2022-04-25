package com.coderscampus.assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.repository.RecipeRepository;

@Service
public class FileRecipesService {

	@Autowired
	private RecipeRepository repo; // repository for recipes

	public Iterable<CSVRecord> readFiles(String fileName) throws IOException {
//		String[] HEADERS = { "Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", "Preparation Minutes",
//		"Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan","Vegetarian" };		
		Reader in = new FileReader(fileName);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(',').withHeader(/* HEADERS */).withEscape('\\').withIgnoreSurroundingSpaces().parse(in);
		return records;
	}

	public List<Recipe> listRecipes() throws IOException {
		
		if (!(repo.getRecipes().isEmpty())) {
			//return null; ===>  NullPointerException results when refreshing the browser 
			return repo.getRecipes();
		} else {
			String fileName = "recipes.txt";
			try {
				Iterable<CSVRecord> recipesRecords = readFiles(fileName);

				for (CSVRecord record : recipesRecords) {
					Recipe recipe = new Recipe(Integer.parseInt(record.get(0)), // Cooking Minutes
							Boolean.parseBoolean(record.get(1)), // Dairy Free
							Boolean.parseBoolean(record.get(2)), // Gluten Free
							record.get(3), // Instructions
							Double.parseDouble(record.get(4)), // Preparation Minutes
							Double.parseDouble(record.get(5)), // cPrice Per Serving
							Integer.parseInt(record.get(6)), // Ready In Minutes
							Integer.parseInt(record.get(7)), // Servings
							Double.parseDouble(record.get(8)), // Spoonacular Score
							record.get(9), // Title
							Boolean.parseBoolean(record.get(10)), // Vegan
							Boolean.parseBoolean(record.get(11)) // Vegetarian
					);

					repo.getRecipes().add(recipe);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			return repo.getRecipes();
		}
	}

}
