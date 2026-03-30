package interview.p01_02;

public class Solution {

    public boolean CheckPermutation(String s1, String s2) {
        int[] m1 = generateMap(s1);
        int[] m2 = generateMap(s2);

        for (int i = 0; i < 26; i++) {
            if (m1[i] != m2[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] generateMap(String s) {
        int[] res = new int[26];
        for (char ch : s.toCharArray()) {
            res[ch - 'a']++;
        }

        return res;
    }
}
