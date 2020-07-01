package l1429;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * FirstUnique
 *
 * @author heshan
 * @date 2020/7/1
 */
public class FirstUnique {

    private Set<Integer> uniqueSet;

    private Set<Integer> duplicateSet;

    private Queue<Integer> queue;

    public FirstUnique(int[] nums) {
        uniqueSet = new HashSet<>();
        duplicateSet = new HashSet<>();
        queue = new LinkedList<>();

        for (int n : nums) {
            add(n);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty()) {
            int n = queue.peek();
            if (duplicateSet.contains(n)) {
                queue.remove();
            } else {
                return n;
            }
        }
        return -1;
    }

    public void add(int value) {
        if (duplicateSet.contains(value)) {
            return;
        }
        if (uniqueSet.contains(value)) {
            uniqueSet.remove(value);
            duplicateSet.add(value);
            return;
        }
        uniqueSet.add(value);
        queue.add(value);
    }
}
