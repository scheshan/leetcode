package interview.p03_06;

import java.util.LinkedList;
import java.util.Queue;

/**
 * AnimalShelf
 *
 * @author heshan
 * @date 2023/3/1
 */
public class AnimalShelf {

    private class Animal {

        int[] pair;

        boolean deleted;

        public Animal(int[] pair) {
            this.pair = pair;
        }
    }

    private Queue<Animal> any;

    private Queue<Animal> dogs;

    private Queue<Animal> cats;

    private int[] notFound = new int[]{-1, -1};

    public AnimalShelf() {
        any = new LinkedList<>();
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        Animal item = new Animal(animal);
        any.add(item);
        if (animal[1] == 1) {
            dogs.add(item);
        } else {
            cats.add(item);
        }
    }

    public int[] dequeueAny() {
        return remove(any);
    }

    public int[] dequeueDog() {
        return remove(dogs);
    }

    public int[] dequeueCat() {
        return remove(cats);
    }

    private int[] remove(Queue<Animal> queue) {
        while (!queue.isEmpty() && queue.peek().deleted) {
            queue.remove();
        }
        if (queue.isEmpty()) {
            return notFound;
        }
        Animal res = queue.remove();
        res.deleted = true;
        return res.pair;
    }
}
