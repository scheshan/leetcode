package l1370;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public String sortString(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        char[] res = new char[s.length()];
        int i = 0;
        while (i < res.length) {
            int j = 0;
            for (; j < count.length; j++) {
                if (count[j] > 0) {
                    res[i++] = (char) (j + 'a');
                    count[j]--;
                }
            }
            for (; j < count.length; j++) {
                if (count[j] > 0) {
                    res[i++] = (char) (j + 'a');
                    count[j]--;
                }
            }

            j = count.length - 1;
            for (; j >= 0; j--) {
                if (count[j] > 0) {
                    res[i++] = (char) (j + 'a');
                    count[j]--;
                }
            }
            for (; j >= 0; j--) {
                if (count[j] > 0) {
                    res[i++] = (char) (j + 'a');
                    count[j]--;
                }
            }
        }

        return new String(res);
    }
}
