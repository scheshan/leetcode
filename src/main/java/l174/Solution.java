package l174;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/12
 */
public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[i].length - 1; j >= 0; j--) {
                if (i == dungeon.length - 1 && j == dungeon[i].length - 1) {
                    dungeon[i][j] = 1 - dungeon[i][j];
                } else {
                    int n = Integer.MAX_VALUE;
                    if (i < dungeon.length - 1) {
                        n = Math.min(n, dungeon[i + 1][j]);
                    }
                    if (j < dungeon[i].length - 1) {
                        n = Math.min(n, dungeon[i][j + 1]);
                    }
                    dungeon[i][j] = n - dungeon[i][j];
                }
                dungeon[i][j] = Math.max(1, dungeon[i][j]);
            }
        }

        return dungeon[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = new int[][]{
                new int[]{-2, -3, 3},
                new int[]{-5, -10, 1},
                new int[]{10, 30, -5}
        };
        int res = new Solution().calculateMinimumHP(dungeon);
        System.out.println(res);
    }
}
