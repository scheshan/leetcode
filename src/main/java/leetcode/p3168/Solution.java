package leetcode.p3168;

public class Solution {

    public int minimumChairs(String s) {
        int res = 0;
        int cur = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'E') {
                cur++;
                res = Math.max(res, cur);
            } else {
                cur--;
            }
        }

        return res;
    }
}
