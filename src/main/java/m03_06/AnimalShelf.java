package m03_06;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/25
 */
public class AnimalShelf {

    private Queue<Animal> dogQueue;

    private Queue<Animal> catQueue;

    private int[] NULL = new int[]{-1, -1};

    public AnimalShelf() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        Animal a = new Animal(animal[1], animal[0]);
        if (a.type == 0) {
            catQueue.add(a);
        } else {
            dogQueue.add(a);
        }
    }

    public int[] dequeueAny() {
        if (dogQueue.isEmpty() && catQueue.isEmpty()) {
            return NULL;
        }

        Animal a = null;
        if (dogQueue.isEmpty()) {
            a = catQueue.poll();
        } else if (catQueue.isEmpty()) {
            a = dogQueue.poll();
        } else {
            Animal dog = dogQueue.peek();
            Animal cat = catQueue.peek();

            if (dog.id < cat.id) {
                dogQueue.poll();
                a = dog;
            } else {
                catQueue.poll();
                a = cat;
            }
        }

        return toArray(a);
    }

    public int[] dequeueDog() {
        if (dogQueue.isEmpty()) {
            return NULL;
        }
        return toArray(dogQueue.poll());
    }

    public int[] dequeueCat() {
        if (catQueue.isEmpty()) {
            return NULL;
        }
        return toArray(catQueue.poll());
    }

    private int[] toArray(Animal a) {
        return new int[]{a.id, a.type};
    }

    private class Animal {

        private int type;

        private int id;

        public Animal(int type, int id) {
            this.type = type;
            this.id = id;
        }
    }
}
