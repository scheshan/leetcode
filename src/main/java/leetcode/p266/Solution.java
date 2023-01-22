package leetcode.p266;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public boolean canPermutePalindrome(String s) {
        boolean[] set = new boolean[128];
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set[s.charAt(i)]) {
                total--;
            } else {
                total++;
            }
            set[s.charAt(i)] = !set[s.charAt(i)];
        }
        return total <= 1;
    }
}
