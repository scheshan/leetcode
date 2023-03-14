package leetcode.p158;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/14
 */
public class Solution extends Reader4 {

    private char[] buffer;

    private int index;

    private int length;

    public Solution() {
        buffer = new char[4];
        length = read4(buffer);
    }

    public int read(char[] buf, int n) {
        int ind = 0;
        while (ind < n && length > 0) {
            int cnt = Math.min(length, n - ind);
            System.arraycopy(buffer, index, buf, ind, cnt);
            ind += cnt;
            index += cnt;
            length -= cnt;

            if (length == 0) {
                index = 0;
                length = read4(buffer);
            }
        }

        return ind;
    }
}
