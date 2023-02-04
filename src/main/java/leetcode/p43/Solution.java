package leetcode.p43;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        List<Character> arr1 = toList(num1);
        List<Character> arr2 = toList(num2);

        List<Character> pre = new ArrayList<>();
        for (int i = 0; i < arr2.size(); i++) {
            pre = sum(pre, multiply(arr1, arr2.get(i), i));
        }
        reverse(pre);

        char[] arr = new char[pre.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = pre.get(i);
        }
        return new String(arr);
    }

    private List<Character> multiply(List<Character> arr, char n, int zero) {
        List<Character> res = new ArrayList<>();
        if (zero > 0) {
            for (int i = 0; i < zero; i++) {
                res.add('0');
            }
        }

        int promotion = 0;
        for (char ch : arr) {
            int num = (ch - '0') * (n - '0');
            if (promotion > 0) {
                num += promotion;
            }
            promotion = num / 10;
            res.add((char) ((num % 10) + '0'));
        }
        if (promotion > 0) {
            res.add((char) (promotion + '0'));
        }
        return res;
    }

    private List<Character> sum(List<Character> arr1, List<Character> arr2) {
        List<Character> res = new ArrayList<>();

        int l = 0;
        int r = 0;
        int promotion = 0;
        while (l < arr1.size() || r < arr2.size() || promotion > 0) {
            int n = promotion;
            promotion = 0;
            if (l < arr1.size()) {
                n += arr1.get(l++) - '0';
            }
            if (r < arr2.size()) {
                n += arr2.get(r++) - '0';
            }
            if (n >= 10) {
                promotion = 1;
                n -= 10;
            }

            res.add((char) (n + '0'));
        }
        return res;
    }

    private void reverse(List<Character> arr) {
        int l = 0;
        int r = arr.size() - 1;
        while (l < r) {
            char t = arr.get(l);
            arr.set(l, arr.get(r));
            arr.set(r, t);
            l++;
            r--;
        }
    }

    private List<Character> toList(String str) {
        List<Character> res = new ArrayList<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            res.add(str.charAt(i));
        }
        reverse(res);
        return res;
    }
}
