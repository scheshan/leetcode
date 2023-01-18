package leetcode.p1089;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public void duplicateZeros(int[] arr) {
        int cnt = 0;
        int ind = 0;
        for (int num : arr) {
            if (num == 0) {
                cnt += 2;
            } else {
                cnt++;
            }
            ind++;
            if (cnt >= arr.length) {
                break;
            }
        }

        ind--;
        cnt--;
        while (cnt >= 0) {
            int num = arr[ind--];
            if (num == 0) {
                if (cnt < arr.length) {
                    arr[cnt] = 0;
                }
                cnt--;
                arr[cnt--] = 0;
            } else {
                arr[cnt--] = num;
            }
        }
    }
}
