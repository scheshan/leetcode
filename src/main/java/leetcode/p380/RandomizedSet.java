package leetcode.p380;

import java.util.*;

/**
 * RandomizedSet
 *
 * @author heshan
 * @date 2023/2/1
 */
public class RandomizedSet {

    private List<Integer> list;

    private Map<Integer, Integer> map;

    private Random rnd;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rnd = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int ind = map.get(val);
        map.remove(val);

        int num = list.get(list.size() - 1);
        if (num != val) {
            map.put(num, ind);
            list.set(ind, num);
        }
        list.remove(list.size() - 1);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int ind = rnd.nextInt(list.size());
        return list.get(ind);
    }
}
