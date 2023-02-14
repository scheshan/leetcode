package leetcode.p2129;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public String capitalizeTitle(String title) {
        char[] arr = title.toCharArray();
        int ind = 0;
        while (ind < arr.length) {
            int pre = ind;
            while (ind < arr.length && arr[ind] != ' ') {
                arr[ind] = Character.toLowerCase(arr[ind]);
                ind++;
            }

            if (ind - pre > 2) {
                arr[pre] = Character.toUpperCase(arr[pre]);
            }

            ind++;
        }

        return new String(arr);
    }
}
