package l253;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/29
 */
public class Solution {

    public int minMeetingRooms(int[][] intervals) {
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] item : intervals) {
            queue.add(item);
        }

        Queue<int[]> arrange = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        while (!queue.isEmpty()) {
            int[] item = queue.remove();
            if (!arrange.isEmpty() && arrange.peek()[1] <= item[0]) {
                int[] pre = arrange.remove();
                pre[1] = item[1];
                arrange.add(pre);
            } else {
                arrange.add(item);
            }
        }
        return arrange.size();
    }

    public static void main(String[] args) {
        int res = new Solution().minMeetingRooms(new int[][]{
                new int[]{5, 8},
                new int[]{6, 8}
        });
        System.out.println(res);
    }
}
