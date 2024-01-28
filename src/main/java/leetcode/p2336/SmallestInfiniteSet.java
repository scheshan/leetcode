package leetcode.p2336;

import java.util.TreeSet;

/**
 * SmallestInfiniteSet
 *
 * @author heshan
 * @date 2024/1/28
 */
public class SmallestInfiniteSet {

    private TreeSet<Integer> set;

    private int cur;

    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        cur = 1;
    }

    public int popSmallest() {
        int res;
        if (set.isEmpty()) {
            res = cur++;
        } else {
            res = set.first();
            set.remove(res);
        }
        return res;
    }

    public void addBack(int num) {
        if (num < cur) {
            set.add(num);
        }
    }
}
