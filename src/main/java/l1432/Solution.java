package l1432;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/16
 */
public class Solution {

    public int maxDiff(int num) {
        String str = String.valueOf(num);

        char[] ch1 = str.toCharArray();
        int i = 0;
        char pre = ' ';
        while (i < ch1.length && ch1[i] == '9') {
            i++;
        }
        if (i < ch1.length) {
            pre = ch1[i];

            while (i < ch1.length) {
                if (ch1[i] == pre) {
                    ch1[i] = '9';
                }
                i++;
            }
        }

        char[] ch2 = str.toCharArray();
        if (ch2[0] == '1') {
            i = 1;
            while (i < ch2.length && (ch2[i] == ch2[0] || ch2[i] == '0')) {
                i++;
            }
            if (i < ch2.length) {
                pre = ch2[i];
                for (int j = 0; j < ch2.length; j++) {
                    if (ch2[j] == pre) {
                        ch2[j] = '0';
                    }
                }
            }
        } else {
            pre = ch2[0];
            for (int j = 0; j < ch2.length; j++) {
                if (ch2[j] == pre) {
                    ch2[j] = '1';
                }
            }
        }

        return Integer.parseInt(new String(ch1)) - Integer.parseInt(new String(ch2));
    }

    public static void main(String[] args) {
        new Solution().maxDiff(1101057);
    }
}
