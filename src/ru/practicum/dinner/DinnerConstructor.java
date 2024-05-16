package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinners;
    Random rand = new Random();

    DinnerConstructor() {
        dinners = new HashMap<>();
    }

    boolean checkType(String type) {
        return dinners.containsKey(type);
    }

    void addNewDish(String dishType, String dishName) {
        if (checkType(dishType)) {
            dinners.get(dishType).add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dinners.put(dishType, dishes);
        }
    }

    ArrayList<HashMap<String, ArrayList<String>>> generateDishCombo(int count, ArrayList<String> dishTypes) {
        ArrayList<HashMap<String, ArrayList<String>>> combos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String title = "Комбо " + (i + 1);
            ArrayList<String> dishes = new ArrayList<>();
            HashMap<String, ArrayList<String>> combo = new HashMap<>();
            if (!dishTypes.isEmpty()) {
                for (String dishType : dishTypes) {
                    if (checkType(dishType)) {
                        int index = rand.nextInt(dinners.get(dishType).size());
                        String dinner = dinners.get(dishType).get(index);
                        dishes.add(dinner);
                    } else {
                        System.out.println("Не найден тип блюда: " + dishType);
                        break;
                    }
                }
            } else {
                System.out.println("Типы блюд не заданы");
                break;
            }
            combo.put(title, dishes);
            combos.add(combo);
        }
        return combos;
    }

}
