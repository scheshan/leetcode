package l1476;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/6/18
 */
public class SubrectangleQueries {

    private int[][] grid;

    public SubrectangleQueries(int[][] rectangle) {
        this.grid = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                grid[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return grid[row][col];
    }
}
