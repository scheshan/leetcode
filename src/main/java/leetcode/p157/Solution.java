package leetcode.p157;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/14
 */
public class Solution extends Reader4 {

    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int ind = 0;

        while (ind < n) {
            int rn = read4(buffer);
            if (rn == 0) {
                break;
            }

            rn = Math.min(n - ind, rn);

            System.arraycopy(buffer, 0, buf, ind, rn);
            ind += rn;
        }

        return ind;
    }
}
