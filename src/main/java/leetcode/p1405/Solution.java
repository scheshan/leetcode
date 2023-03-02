package leetcode.p1405;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public String longestDiverseString(int a, int b, int c) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            int n = Integer.compare(o2[1], o1[1]);
            if (n != 0) {
                return n;
            }
            return Integer.compare(o1[0], o2[0]);
        });
        if (a > 0) {
            queue.add(new int[]{0, a});
        }
        if (b > 0) {
            queue.add(new int[]{1, b});
        }
        if (c > 0) {
            queue.add(new int[]{2, c});
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] a1 = queue.remove();
            int[] a2 = null;
            if (!queue.isEmpty()) {
                a2 = queue.remove();
            }

            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == 'a' + a1[0]) {
                if (a2 == null) {
                    break;
                }
                append(sb, a2, 1);
                append(sb, a1, 2);
            } else {
                append(sb, a1, 2);
                append(sb, a2, 1);
            }

            if (a1[1] > 0) {
                queue.add(a1);
            }
            if (a2 != null && a2[1] > 0) {
                queue.add(a2);
            }
        }

        return sb.toString();
    }

    private void append(StringBuilder sb, int[] arr, int cnt) {
        if (arr == null) {
            return;
        }

        int c = Math.min(arr[1], cnt);
        for (int i = 0; i < c; i++) {
            sb.append((char) ('a' + arr[0]));
        }
        arr[1] -= c;
    }
}
