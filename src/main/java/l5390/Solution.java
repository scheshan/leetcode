package l5390;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public int minNumberOfFrogs(String croakOfFrogs) {
        //croak
        int[] count = new int[5];

        int max = 0;
        int cur = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char ch = croakOfFrogs.charAt(i);
            int ind = index(ch);

            if (ind < 0) {
                return -1;
            }
            if (ind == 0) {
                count[0]++;
                cur++;
                max = Math.max(max, cur);
            } else {
                if (count[ind - 1] == 0) {
                    return -1;
                }
                count[ind - 1]--;

                if (ind == 4) {
                    cur--;
                } else {
                    count[ind]++;
                }
            }
        }

        return cur == 0 ? max : -1;
    }

    private int index(char ch) {
        if (ch == 'c') {
            return 0;
        } else if (ch == 'r') {
            return 1;
        } else if (ch == 'o') {
            return 2;
        } else if (ch == 'a') {
            return 3;
        } else if (ch == 'k') {
            return 4;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minNumberOfFrogs("croakcroak"));
        System.out.println(solution.minNumberOfFrogs("crcoakroak"));
        System.out.println(solution.minNumberOfFrogs("croakcrook"));
        System.out.println(solution.minNumberOfFrogs("croakcroa"));
    }
}
