package l489;

import java.util.HashSet;
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
        perm(robot, 0, 0, 0, states, new HashSet<>());
    }

    private void perm(Robot robot, int x, int y, int direction, int[][] states, Set<String> visited) {
        robot.clean();
        visited.add(x + "," + y);

        for (int i = 0; i < 4; i++) {
            int ind = (direction + i) % 4;
            int x1 = x + states[ind][0];
            int y1 = y + states[ind][1];

            if (!visited.contains(x1 + "," + y1) && robot.move()) {
                perm(robot, x1, y1, ind, states, visited);

                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }

            robot.turnRight();
        }
    }
}
