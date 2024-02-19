package leetcode.p380;

import java.util.*;

/**
 * RandomizedSet
 *
 * @author heshan
 * @date 2024/2/19
 */
public class RandomizedSet {

    private Map<Integer, Integer> map;

    private List<Integer> list;

    private Random rnd;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>(200000);
        rnd = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int ind = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(ind, last);
        list.remove(list.size() - 1);
        map.put(last, ind);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int ind = rnd.nextInt(list.size());
        return list.get(ind);
    }
}
