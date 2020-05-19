package l1387;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/19
 */
public class Solution {

    private Map<Integer, Integer> map;

    public int getKth(int lo, int hi, int k) {
        map = new HashMap<>();
        map.put(1, 0);

        List<Integer> nums = new ArrayList<>(hi - lo + 1);
        for (int i = lo; i <= hi; i++) {
            nums.add(i);
        }

        nums.sort(Comparator.comparingInt(n -> calculate(n, map)));

        return nums.get(k - 1);
    }

    private int calculate(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int weight;
        if ((n & 1) == 0) {
            weight = calculate(n / 2, map) + 1;
        } else {
            weight = calculate(n * 3 + 1, map) + 1;
        }
        map.put(n, weight);
        return weight;
    }

    public static void main(String[] args) {
        new Solution().getKth(7, 11, 4);
    }
}
