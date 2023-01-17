package leetcode.p379;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * PhoneDirectory
 *
 * @author heshan
 * @date 2023/1/17
 */
public class PhoneDirectory {

    private Queue<Integer> queue;
    private Set<Integer> pool;

    private int cur;

    private int max;

    public PhoneDirectory(int maxNumbers) {
        queue = new LinkedList<>();
        pool = new HashSet<>();
        max = maxNumbers;
        cur = 0;
    }

    public int get() {
        int res = -1;
        if (!queue.isEmpty()) {
            res = queue.remove();
            pool.remove(res);
        } else if (cur < max) {
            res = cur++;
        }
        return res;
    }

    public boolean check(int number) {
        if (number >= max) {
            return false;
        }
        if (number >= cur) {
            return true;
        }
        return pool.contains(number);
    }

    public void release(int number) {
        if (number >= cur) {
            return;
        }
        if (pool.contains(number)) {
            return;
        }
        queue.add(number);
        pool.add(number);
    }
}
