package leetcode.p759;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/1
 */
public class Solution {

    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            Interval i1 = schedule.get(o1[0]).get(o1[1]);
            Interval i2 = schedule.get(o2[0]).get(o2[1]);
            int n = Integer.compare(i1.start, i2.start);
            if (n != 0) {
                return n;
            }
            return Integer.compare(i1.end, i2.end);
        });
        for (int i = 0; i < schedule.size(); i++) {
            queue.add(new int[]{i, 0});
        }

        int pre = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int[] pair = queue.remove();
            Interval interval = schedule.get(pair[0]).get(pair[1]);
            if (interval.start > pre) {
                if (pre != Integer.MIN_VALUE) {
                    res.add(new Interval(pre, interval.start));
                }
            }
            pre = Math.max(pre, interval.end);
            pair[1]++;
            if (pair[1] < schedule.get(pair[0]).size()) {
                queue.add(pair);
            }
        }

        return res;
    }
}
