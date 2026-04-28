package com.macros.macrostracker.controller;

import com.macros.macrostracker.repository.IngredientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
public class IngredientControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    IngredientRepository ingredientRepository;

    @Test
    void shouldCreateIngredient() throws Exception {
        String json = """
                {
                    "name": "Chicken",
                    "caloriesPer100g": 165,
                    "carbsPer100g": 4,
                    "proteinPer100g": 18,
                    "fatPer100g": 2.1
                }
                """;

        mockMvc.perform(post("/api/ingredients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldGetIngredients() throws Exception {
        mockMvc.perform(get("/api/ingredients"))
                .andExpect(status().isOk());
    }
}
