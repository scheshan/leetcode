package leetcode.p2336;

import java.util.TreeSet;

/**
 * SmallestInfiniteSet
 *
 * @author heshan
 * @date 2023/2/22
 */
public class SmallestInfiniteSet {

    private int next;

    private TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        next = 1;
        set = new TreeSet<>();
    }

    public int popSmallest() {
        int res;
        if (!set.isEmpty()) {
            res = set.first();
            set.remove(res);
        } else {
            res = next++;
        }
        return res;
    }

    public void addBack(int num) {
        if (num >= next) {
            return;
        }
        set.add(num);
    }
}
