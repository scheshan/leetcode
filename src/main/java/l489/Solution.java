package l489;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/14
 */
public class Solution {

    public void cleanRoom(Robot robot) {
        int[][] states = new int[][]{
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{-1, 0},
                new int[]{0, 1}
        };
        perm(robot, new Point(0, 0), 0, states, new HashSet<>());
    }

    private void perm(Robot robot, Point p, int direction, int[][] states, Set<Point> visited) {
        robot.clean();
        visited.add(p);

        for (int i = 0; i < 4; i++) {
            int ind = (direction + i) % 4;
            int x1 = p.x + states[ind][0];
            int y1 = p.y + states[ind][1];
            Point p1 = new Point(p.x + states[ind][0], p.y + states[ind][1]);

            if (!visited.contains(p1) && robot.move()) {
                perm(robot, p1, ind, states, visited);

                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }

            robot.turnRight();
        }
    }

    private class Point {

        int x;

        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
