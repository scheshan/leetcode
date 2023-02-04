package leetcode.p251;

/**
 * Vector2D
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Vector2D {

    private int i;

    private int j;

    private int[][] vec;

    public Vector2D(int[][] vec) {
        this.vec = vec;
        prune();
    }

    public int next() {
        int res = vec[i][j];
        j++;
        prune();
        return res;
    }

    public boolean hasNext() {
        if (i >= vec.length) {
            return false;
        }
        return j < vec[i].length;
    }

    private void prune() {
        while (i < vec.length && j == vec[i].length) {
            j = 0;
            i++;
        }
    }
}
