package leetcode.p990;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/16
 */
public class Solution {

    public boolean equationsPossible(String[] equations) {
        int[] uf = new int[26];
        for (int i = 0; i < 26; i++) {
            uf[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                connect(uf, str.charAt(0) - 'a', str.charAt(3) - 'a');
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                if (isConnected(uf, str.charAt(0) - 'a', str.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
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
            uf[p1] = p2;
        }
    }

    private boolean isConnected(int[] uf, int i, int j) {
        return getParent(uf, i) == getParent(uf, j);
    }
}
