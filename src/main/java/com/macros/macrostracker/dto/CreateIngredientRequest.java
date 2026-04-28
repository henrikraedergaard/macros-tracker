package com.macros.macrostracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record CreateIngredientRequest(
        @NotBlank String name,
        @PositiveOrZero double caloriesPer100g,
        @PositiveOrZero double proteinPer100g,
        @PositiveOrZero double carbsPer100g,
        @PositiveOrZero double fatPer100g
) {
}
