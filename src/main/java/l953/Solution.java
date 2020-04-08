package l953;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/8
 */
public class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) {
            return true;
        }

        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (!less(words[i - 1], words[i], orderMap)) {
                return false;
            }
        }

        return true;
    }

    private boolean less(String left, String right, int[] order) {
        int l = 0, r = 0;

        while (l < left.length() && r < right.length()) {
            if (order[left.charAt(l) - 'a'] < order[right.charAt(r) - 'a']) {
                return true;
            } else if (order[left.charAt(l) - 'a'] > order[right.charAt(r) - 'a']) {
                return false;
            }
            l++;
            r++;
        }

        if (l < left.length()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution().isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
    }
}
