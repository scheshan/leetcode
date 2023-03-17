package leetcode.p1202;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/16
 */
public class Solution {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] uf = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            uf[i] = i;
        }
        for (List<Integer> pair : pairs) {
            connect(uf, pair.get(0), pair.get(1));
        }

        Map<Integer, Queue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int p = getParent(uf, i);
            Queue<Character> queue = map.get(p);
            if (queue == null) {
                queue = new PriorityQueue<>(Character::compareTo);
                map.put(p, queue);
            }
            queue.add(s.charAt(i));
        }

        char[] arr = new char[s.length()];
        for (int i = 0; i < arr.length; i++) {
            int p = getParent(uf, i);
            arr[i] = map.get(p).remove();
        }
        return new String(arr);
    }

    private int getParent(int[] uf, int i) {
        while (i != uf[i]) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }

        return i;
    }

    private void connect(int[] uf, int i, int j) {
        int p1 = getParent(uf, i);
        int p2 = getParent(uf, j);
        if (p1 != p2) {
            uf[p1] = p2;
        }
    }
}
