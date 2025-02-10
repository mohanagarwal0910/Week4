package com.capgeminitrainingday1;

// Define the MealPlan interface
interface MealPlan {
    void showMeal();
}

// Subtypes implementing MealPlan
class VegetarianMeal implements MealPlan {
    @Override
    public void showMeal() {
        System.out.println("Vegetarian Meal: Salad, Lentil Soup, and Grilled Paneer.");
    }
}

class VeganMeal implements MealPlan {
    @Override
    public void showMeal() {
        System.out.println("Vegan Meal: Quinoa Bowl, Avocado Toast, and Tofu Stir-fry.");
    }
}

class KetoMeal implements MealPlan {
    @Override
    public void showMeal() {
        System.out.println("Keto Meal: Grilled Chicken, Avocado Salad, and Cauliflower Rice.");
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public void showMeal() {
        System.out.println("High Protein Meal: Steak, Eggs, and Greek Yogurt.");
    }
}

// Generic Meal class
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void showMealPlan() {
        mealPlan.showMeal();
    }
}

// Meal Plan Generator with generic method
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        return new Meal<>(mealPlan);
    }
}

// Main class to test the implementation
public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        // Generate different meal plans dynamically
        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(new VeganMeal());
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal());
        Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.generateMealPlan(new HighProteinMeal());

        // Display meals
        vegMeal.showMealPlan();
        veganMeal.showMealPlan();
        ketoMeal.showMealPlan();
        highProteinMeal.showMealPlan();
    }
}
