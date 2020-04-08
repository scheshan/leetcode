package l868;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/8
 */
public class Solution {

    public int binaryGap(int N) {
        boolean start = false;
        int res = 0;
        int cur = 0;

        while (N != 0) {
            if ((N & 1) == 1) {
                cur = 1;
                if (!start) {
                    start = true;
                } else {
                    res = Math.max(res, cur);
                }
            } else {
                if(start) {
                    cur++;
                    res = Math.max(res, cur);
                }
            }
            N = N >> 1;
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().binaryGap(5);
    }
}
