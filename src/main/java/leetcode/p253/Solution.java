package leetcode.p253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/13
 */
public class Solution {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        Queue<int[]> queue = new PriorityQueue<>(intervals.length, Comparator.comparingInt(o -> o[1]));
        for (int[] interval : intervals) {
            if(!queue.isEmpty() && queue.peek()[1] <= interval[0]) {
                int[] pre = queue.remove();
                pre[1] = interval[1];
                queue.add(pre);
            } else {
                queue.add(interval);
            }
        }

        return queue.size();
    }
}
