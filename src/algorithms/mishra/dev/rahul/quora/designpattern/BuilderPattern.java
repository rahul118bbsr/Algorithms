package algorithms.mishra.dev.rahul.quora.designpattern;

import java.util.Objects;

/**
 * Created by aleesha on 20/07/17.
 */
public class BuilderPattern {

    public static void main(String[] args) {
        MealBuilder.getInstance().buildMeal("INDIAN");
        MealBuilder.getInstance().buildMeal("ITALIAN");
        MealBuilder.getInstance().buildMeal("THAI");
        MealBuilder.getInstance().buildMeal("CONTINENTAL");
    }
}

interface Meal {
    Meal buildEntree();
    Meal buildMainCourse();
    Meal buildDeserts();
}

class ItalianMeal implements Meal {

    @Override
    public Meal buildEntree() {
        System.out.println("Preparing Italian Entree");
        return this;
    }

    @Override
    public Meal buildMainCourse() {
        System.out.println("Preparing Italian Main Course");
        return this;
    }

    @Override
    public Meal buildDeserts() {
        System.out.println("Preparing Italian Deserts");
        return this;
    }
}

class IndianMeal implements Meal {

    @Override
    public Meal buildEntree() {
        System.out.println("Preparing Indian Entree");
        return this;
    }

    @Override
    public Meal buildMainCourse() {
        System.out.println("Preparing Indian Main Course");
        return this;
    }

    @Override
    public Meal buildDeserts() {
        System.out.println("Preparing Indian Deserts");
        return this;
    }
}

class ThaiMeal implements Meal {

    @Override
    public Meal buildEntree() {
        System.out.println("Preparing Thai Entree");
        return this;
    }

    @Override
    public Meal buildMainCourse() {
        System.out.println("Preparing Thai Main Course");
        return this;
    }

    @Override
    public Meal buildDeserts() {
        System.out.println("Preparing Thai Deserts");
        return this;
    }
}

class MealBuilder {
    private static MealBuilder mealBuilder;

    private MealBuilder() {
        if(!Objects.isNull(mealBuilder)) {
            throw new RuntimeException("Builder Instance is already present.");
        }
    }

    public static MealBuilder getInstance() {
        if (Objects.isNull(mealBuilder)) {
            mealBuilder = new MealBuilder();
        }
        return mealBuilder;
    }

    public Meal buildMeal(String mealType) {
        return MealFactory.getInstance().getMealType(mealType)
                .buildEntree()
                .buildMainCourse()
                .buildDeserts();
    }
}

class MealFactory {
    private static MealFactory mealFactory;

    private MealFactory() {
    }

    public static MealFactory getInstance() {
        if (Objects.isNull(mealFactory)) {
            mealFactory = new MealFactory();
        }
        return mealFactory;
    }

    public Meal getMealType(String mealType) {
        mealType = mealType.toUpperCase();
        if (Objects.equals("INDIAN", mealType)) {
            return new IndianMeal();
        }
        if (Objects.equals("ITALIAN", mealType)) {
            return new ItalianMeal();
        }
        if (Objects.equals("THAI", mealType)) {
            return new ThaiMeal();
        }
        throw new IllegalArgumentException("Sorry, we are currently not offering " + mealType + " food.");
    }
}

