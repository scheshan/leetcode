package l980;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/21
 */
public class Solution {

    public int uniquePathsIII(int[][] grid) {
        int[] start = new int[2];
        int[] end = new int[2];
        int zero = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    zero++;
                } else if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        return perm(grid, start[0], start[1], zero, end);
    }

    private int perm(int[][] grid, int i, int j, int zero, int[] end) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] < 0) {
            return 0;
        }

        if (i == end[0] && j == end[1]) {
            if (zero == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (grid[i][j] == 0) {
            zero--;
        }
        grid[i][j] -= 5;

        int res = 0;
        res += perm(grid, i - 1, j, zero, end);
        res += perm(grid, i + 1, j, zero, end);
        res += perm(grid, i, j - 1, zero, end);
        res += perm(grid, i, j + 1, zero, end);

        grid[i][j] += 5;
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().uniquePathsIII(new int[][]{
                new int[]{1, 0, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 2, -1}
        });
        System.out.println(res);
    }
}
