package leetcode.p58;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        int ind = s.length() - 1;
        while (ind >= 0 && s.charAt(ind) == ' ') {
            ind--;
        }

        int res = 0;
        while (ind >= 0 && s.charAt(ind) != ' ') {
            ind--;
            res++;
        }
        return res;
    }
}
