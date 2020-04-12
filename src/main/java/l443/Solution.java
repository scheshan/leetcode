package l443;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/12
 */
public class Solution {

    public int compress(char[] chars) {
        int i = 1;
        int j = 0;

        char prev = chars[0];
        int cur = 1;
        while (i < chars.length) {
            if (prev != chars[i]) {
                j = append(chars, j, prev, cur);

                prev = chars[i];
                cur = 1;
            } else {
                cur++;
            }
            i++;
        }
        j = append(chars, j, prev, cur);

        return j;
    }

    private int append(char[] chars, int i, char ch, int count) {
        chars[i++] = ch;
        String c = String.valueOf(count);

        if (count > 1) {
            for (int j = 0; j < c.length(); j++) {
                chars[i++] = c.charAt(j);
            }
        }

        return i;
    }

    public static void main(String[] args) {
        char[] arr = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int res = new Solution().compress(arr);
        System.out.println(res);
    }
}
