package l5388;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public String reformat(String s) {
        char[] res = new char[s.length()];
        int nums = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                nums++;
            }
        }

        int i, j;
        if (nums >= s.length() - nums) {
            i = 0;
            j = 1;
        } else {
            i = 1;
            j = 0;
        }

        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) >= '0' && s.charAt(k) <= '9') {
                if (i >= res.length) {
                    return "";
                }
                res[i] = s.charAt(k);
                i += 2;
            } else {
                if (j >= res.length) {
                    return "";
                }
                res[j] = s.charAt(k);
                j += 2;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reformat("a0b1c2"));
        System.out.println(solution.reformat("leetcode"));
        System.out.println(solution.reformat("1229857369"));
        System.out.println(solution.reformat("covid2019"));
        System.out.println(solution.reformat("ab123"));
    }
}
