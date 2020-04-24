package l379;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class PhoneDirectory {

    private Deque<Integer> available;

    private Set<Integer> used;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public PhoneDirectory(int maxNumbers) {
        available = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
            available.add(i);
        }
        used = new HashSet<>(maxNumbers);
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (available.isEmpty()) {
            return -1;
        }

        int n = available.removeFirst();
        used.add(n);
        return n;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return !used.contains(number);
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        if (!used.contains(number)) {
            return;
        }

        used.remove(number);
        available.addFirst(number);
    }
}
