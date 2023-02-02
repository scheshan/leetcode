package interview.p17_14;

import java.util.Random;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    private Random rnd = new Random();

    public int[] smallestK(int[] arr, int k) {
        quickFind(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void quickFind(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }

        int pivot = rnd.nextInt(r - l) + l;
        swap(arr, l, pivot);
        int mid = partition(arr, l, r);
        if (mid == k) {
            return;
        } else if (mid < k) {
            quickFind(arr, mid + 1, r, k);
        } else {
            quickFind(arr, l, mid - 1, k);
        }
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int start = l;

        while (l < r) {
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            if (l < r) {
                swap(arr, l, r);
            }
        }
        swap(arr, start, l);
        return l;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
