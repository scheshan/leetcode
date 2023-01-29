package leetcode.p1869;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public boolean checkZeroOnes(String s) {
        int n0 = 0;
        int n1 = 0;

        int slow = 0;
        while (slow < s.length()) {
            int fast = slow + 1;
            while (fast < s.length() && s.charAt(fast) == s.charAt(slow)) {
                fast++;
            }
            if (s.charAt(slow) == '0') {
                n0 = Math.max(n0, fast - slow);
            } else {
                n1 = Math.max(n1, fast - slow);
            }
            slow = fast;
        }

        return n1 > n0;
    }
}
