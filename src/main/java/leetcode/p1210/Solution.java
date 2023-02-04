package leetcode.p1210;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/5
 */
public class Solution {

    private class Pos {
        int row1;
        int col1;
        int row2;
        int col2;

        public Pos(int row1, int col1, int row2, int col2) {
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return row1 == pos.row1 && col1 == pos.col1 && row2 == pos.row2 && col2 == pos.col2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row1, col1, row2, col2);
        }
    }

    public int minimumMoves(int[][] grid) {
        Queue<Pos> queue = new LinkedList<>();
        Set<Pos> visit = new HashSet<>();
        addQueue(queue, new Pos(0, 0, 0, 1), visit);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Pos pos = queue.remove();
                if (isEnd(grid, pos)) {
                    return step;
                }
                addQueue(queue, moveDown(grid, pos), visit);
                addQueue(queue, moveRight(grid, pos), visit);
                addQueue(queue, rotateHorizontal(grid, pos), visit);
                addQueue(queue, rotateVertical(grid, pos), visit);
            }
            step++;
        }

        return -1;
    }

    private void addQueue(Queue<Pos> queue, Pos pos, Set<Pos> visit) {
        if (pos == null) {
            return;
        }
        if (visit.contains(pos)) {
            return;
        }

        visit.add(pos);
        queue.add(pos);
    }

    private boolean isEnd(int[][] grid, Pos pos) {
        return pos.row1 == grid.length - 1
                && pos.row2 == grid.length - 1
                && pos.col1 == grid[grid.length - 1].length - 2
                && pos.col2 == grid[grid.length - 1].length - 1;
    }

    private boolean isRight(Pos pos) {
        return pos.row1 == pos.row2;
    }

    private Pos moveRight(int[][] grid, Pos pos) {
        if (pos.col2 < grid[pos.row2].length - 1 && grid[pos.row1][pos.col1 + 1] == 0 && grid[pos.row2][pos.col2 + 1] == 0) {
            return new Pos(pos.row1, pos.col1 + 1, pos.row2, pos.col2 + 1);
        }
        return null;
    }

    private Pos moveDown(int[][] grid, Pos pos) {
        if (pos.row2 < grid.length - 1 && grid[pos.row2 + 1][pos.col2] == 0 && grid[pos.row1 + 1][pos.col1] == 0) {
            return new Pos(pos.row1 + 1, pos.col1, pos.row2 + 1, pos.col2);
        }
        return null;
    }

    private Pos rotateHorizontal(int[][] grid, Pos pos) {
        if (isRight(pos)) {
            return null;
        }
        if (pos.col1 < grid[pos.row1].length - 1 && grid[pos.row1][pos.col1 + 1] == 0 && grid[pos.row2][pos.col2 + 1] == 0) {
            return new Pos(pos.row1, pos.col1, pos.row1, pos.col1 + 1);
        }
        return null;
    }

    private Pos rotateVertical(int[][] grid, Pos pos) {
        if (!isRight(pos)) {
            return null;
        }
        if (pos.row1 < grid.length - 1 && grid[pos.row1 + 1][pos.col1] == 0 && grid[pos.row1 + 1][pos.col2] == 0) {
            return new Pos(pos.row1, pos.col1, pos.row1 + 1, pos.col1);
        }
        return null;
    }
}
