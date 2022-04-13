# tristan-assignment-9
 Spring Framework of Week 13
Ingest a recipe.txt file and store this information in a Java Collection (ArrayList).
Use the Apache Commons CSV project to parse the text file.


POJO file:
**********
public class Recipe {

     private Integer cookingMinutes;

     private Boolean dairyFree;

     private Boolean glutenFree;

     private String instructions;

     private Double preparationMinutes;

     private Double pricePerServing;

     private Integer readyInMinutes;

     private Integer servings;

     private Double spoonacularScore;

     private String title;

     private Boolean vegan;

     private Boolean vegetarian;

}


“endpoints” is inside of a RestController that will filter this data:
********************************************************************

@GetMapping("/gluten-free")

@GetMapping("/vegan")

@GetMapping("/vegan-and-gluten-free")

@GetMapping("/vegetarian")

@GetMapping("/all-recipes")


Instructions:
*************
- visit the website: start.spring.io
- Download a fresh new Spring Boot project
- Import it into IDE ( Eclipse (
