package l1180;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/26
 */
public class Solution {

    public int countLetters(String S) {
        int res = 0;

        int cur = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i == 0 || S.charAt(i) == S.charAt(i - 1)) {
                cur++;
            } else {
                res += (1 + cur) * cur / 2;
                cur = 1;
            }
        }

        res += (1 + cur) * cur / 2;
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().countLetters("aaaaaaaaaa");
        System.out.println(res);
    }
}
