package l696;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/15
 */
public class Solution {

    public int countBinarySubstrings(String s) {
        int preCount = 0;
        int curCount = 1;
        char cur = s.charAt(0);

        int res = 0;

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == cur) {
                curCount++;
            } else {
                if (preCount > 0) {
                    res += Math.min(preCount, curCount);
                }
                preCount = curCount;
                curCount = 1;
                cur = ch;
            }
        }

        res += Math.min(preCount, curCount);

        return res;
    }

    public static void main(String[] args) {
        new Solution().countBinarySubstrings("10101");
    }
}
