package leetcode.p1061;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/16
 */
public class Solution {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] uf = new int[26];
        for (int i = 0; i < 26; i++) {
            uf[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            connect(uf, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        char[] arr = new char[baseStr.length()];
        for (int i = 0; i < arr.length; i++) {
            int p = getParent(uf, baseStr.charAt(i) - 'a');
            arr[i] = (char) ('a' + p);
        }

        return new String(arr);
    }

    private int getParent(int[] uf, int i) {
        while (i != uf[i]) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }

    private void connect(int[] uf, int i, int j) {
        int p1 = getParent(uf, i);
        int p2 = getParent(uf, j);

        if (p1 != p2) {
            if (p1 < p2) {
                uf[p2] = p1;
            } else {
                uf[p1] = p2;
            }
        }
    }
}
