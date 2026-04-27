package com.macros.macrostracker.controllers;

import com.macros.macrostracker.entities.Ingredient;
import com.macros.macrostracker.dtos.CreateIngredientRequest;
import com.macros.macrostracker.repositories.IngredientRepository;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient createIngredient(@Valid @RequestBody CreateIngredientRequest request) {
        Ingredient ingredient = Ingredient.builder()
                .name(request.name())
                .fatPer100g(request.fatPer100g())
                .proteinPer100g(request.proteinPer100g())
                .carbsPer100g(request.carbsPer100g())
                .build();

        return ingredientRepository.save(ingredient);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ingredient> getIngredient() {
        return ingredientRepository.findAll();
    }
}
