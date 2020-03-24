package m17_14;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }

        int n = 0;

        for (int num : arr) {
            if (n < k) {
                res[n] = num;
                up(res, n);

                n++;
            } else {
                if (res[0] > num) {
                    swap(res, 0, n - 1);
                    n--;
                    down(res, n);

                    res[n] = num;
                    up(res, n);
                    n++;
                }
            }
        }

        return res;
    }

    private void up(int[] arr, int i) {
        while ((i - 1) / 2 >= 0) {
            if (arr[(i - 1) / 2] < arr[i]) {
                swap(arr, i, (i - 1) / 2);
                i = (i - 1) / 2;
            } else {
                break;
            }
        }
    }

    private void down(int[] arr, int n) {
        int i = 0;
        while (i * 2 + 1 < n) {
            int max = arr[i];
            int ind = i;
            if (arr[i * 2 + 1] > max) {
                ind = i * 2 + 1;
                max = arr[i * 2 + 1];
            }
            if (i * 2 + 2 < n) {
                if (arr[i * 2 + 2] > max) {
                    max = arr[i * 2 + 2];
                    ind = i * 2 + 2;
                }
            }

            if (ind == i) {
                break;
            }
            swap(arr, i, ind);
            i = ind;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = new Solution().smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
        System.out.println(Arrays.toString(arr));
    }
}
