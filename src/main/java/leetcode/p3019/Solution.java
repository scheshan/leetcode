package leetcode.p3019;

public class Solution {

    public int countKeyChanges(String s) {
        int res = 0;

        for (int i = 1; i < s.length(); i++) {
            if (getKeyCode(s.charAt(i)) != getKeyCode(s.charAt(i - 1))) {
                res++;
            }
        }

        return res;
    }

    private int getKeyCode(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return ch - 'a';
        }
        return ch - 'A';
    }
}
