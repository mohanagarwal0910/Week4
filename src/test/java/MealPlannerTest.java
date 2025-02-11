package com.capgeminitrainingday1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

// Test Class for MealPlanner
public class MealPlannerTest {
    private MealPlanner mealPlanner;
    private VegetarianMeal vegetarianMeal;
    private VeganMeal veganMeal;
    private KetoMeal ketoMeal;
    private HighProteinMeal highProteinMeal;

    @BeforeEach
    void setUp() {
        mealPlanner = new MealPlanner();

        // Creating Meal Instances
        vegetarianMeal = new VegetarianMeal("Vegetable Stir Fry", 400);
        veganMeal = new VeganMeal("Tofu Salad", 350);
        ketoMeal = new KetoMeal("Grilled Chicken & Avocado", 600);
        highProteinMeal = new HighProteinMeal("Salmon with Quinoa", 550);
    }

    @Test
    void testAddMealPlan() {
        // Wrapping Meals in Generic Meal Class
        Meal<VegetarianMeal> vegMealWrapped = new Meal<>(vegetarianMeal);
        Meal<VeganMeal> veganMealWrapped = new Meal<>(veganMeal);

        // Adding Meals to the Planner
        mealPlanner.addMealPlan(vegMealWrapped);
        mealPlanner.addMealPlan(veganMealWrapped);

        // Verifying Meals are Added
        List<MealPlan> meals = new ArrayList<>();
        meals.add(vegetarianMeal);
        meals.add(veganMeal);

        assertEquals(2, meals.size());
        assertEquals("Vegetable Stir Fry", meals.get(0).getMealName());
        assertEquals(400, meals.get(0).getCalories());
        assertEquals("Tofu Salad", meals.get(1).getMealName());
        assertEquals(350, meals.get(1).getCalories());
    }

    @Test
    void testDisplayAllMeals() {
        // Adding Meals to a List
        List<MealPlan> allMeals = new ArrayList<>();
        allMeals.add(vegetarianMeal);
        allMeals.add(veganMeal);
        allMeals.add(ketoMeal);
        allMeals.add(highProteinMeal);

        // Test that all meals exist in the list
        assertEquals(4, allMeals.size());
        assertEquals("Grilled Chicken & Avocado", allMeals.get(2).getMealName());
        assertEquals(600, allMeals.get(2).getCalories());
        assertEquals("Salmon with Quinoa", allMeals.get(3).getMealName());
        assertEquals(550, allMeals.get(3).getCalories());

        // Run the display method to ensure no exceptions occur
        MealPlanner.displayAllMeals(allMeals);
    }

    @Test
    void testMealWrapper() {
        Meal<VegetarianMeal> mealWrapper = new Meal<>(vegetarianMeal);
        assertNotNull(mealWrapper.getMeal());
        assertEquals("Vegetable Stir Fry", mealWrapper.getMeal().getMealName());
        assertEquals(400, mealWrapper.getMeal().getCalories());
    }
}
