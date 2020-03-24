package l973;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    private class Point {

        int x;

        int y;

        double distance;

        public Point(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> queue = new PriorityQueue<>(K, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Double.compare(o2.distance, o1.distance);
            }
        });
        for (int[] point : points) {
            Point p = new Point(point[0], point[1], Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2)));

            if (queue.size() < K) {
                queue.add(p);
            } else {
                if (p.distance < queue.peek().distance) {
                    queue.remove();
                    queue.add(p);
                }
            }
        }

        int[][] res = new int[K][2];
        int i = 0;
        for (Point p : queue) {
            res[i++] = new int[]{p.x, p.y};
        }

        return res;
    }
}
