package leetcode.p2353;

import java.util.*;

/**
 * FoodRatings
 *
 * @author heshan
 * @date 2023/2/22
 */
public class FoodRatings {

    private class Item {

        private String food;

        private String cuisine;

        private int rating;

        private boolean delete;

        public Item(String food, String cuisine, int rating) {
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    private Map<String, Item> foodMap;

    private Map<String, Queue<Item>> cuisineMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            Item item = new Item(food, cuisine, ratings[i]);

            foodMap.put(food, item);
            if (!cuisineMap.containsKey(cuisine)) {
                cuisineMap.put(cuisine, new PriorityQueue<>((o1, o2) -> {
                    int d = Integer.compare(o2.rating, o1.rating);
                    if (d != 0) {
                        return d;
                    }
                    return o1.food.compareTo(o2.food);
                }));
            }
            cuisineMap.get(cuisine).add(item);
        }
    }

    public void changeRating(String food, int newRating) {
        Item item = foodMap.get(food);
        item.delete = true;

        Item newItem = new Item(food, item.cuisine, newRating);
        foodMap.put(food, newItem);
        cuisineMap.get(item.cuisine).add(newItem);
    }

    public String highestRated(String cuisine) {
        Queue<Item> queue = cuisineMap.get(cuisine);
        prune(queue);

        return queue.peek().food;
    }

    private void prune(Queue<Item> queue) {
        while (!queue.isEmpty() && queue.peek().delete) {
            queue.remove();
        }
    }
}
