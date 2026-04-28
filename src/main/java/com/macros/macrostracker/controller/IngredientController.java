package com.macros.macrostracker.controller;

import com.macros.macrostracker.entity.Ingredient;
import com.macros.macrostracker.dto.CreateIngredientRequest;
import com.macros.macrostracker.repository.IngredientRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ingredients", description = "Manage ingredients and their macro nutrient values")
@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Operation(
            summary = "Create a new ingredient",
            description = "Creates an ingredient with macro values per 100 grams."
    )
    @ApiResponse(responseCode = "201", description = "Ingredient created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid ingredient payload")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient createIngredient(@Valid @RequestBody CreateIngredientRequest request) {
        Ingredient ingredient = Ingredient.builder()
                .name(request.name())
                .caloriesPer100g(request.caloriesPer100g())
                .fatPer100g(request.fatPer100g())
                .proteinPer100g(request.proteinPer100g())
                .carbsPer100g(request.carbsPer100g())
                .build();

        return ingredientRepository.save(ingredient);
    }

    @Operation(
            summary = "Get all ingredients",
            description = "Returns all ingredients stored in the system."
    )
    @ApiResponse(responseCode = "200", description = "Ingredients returned successfully")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ingredient> getIngredient() {
        return ingredientRepository.findAll();
    }
}
