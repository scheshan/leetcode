package leetcode.p772;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/15
 */
public class Solution {

    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();

        int ind = 0;
        while (ind < s.length()) {
            switch (s.charAt(ind)) {
                case '(':
                    ops.addLast('(');
                    ind++;
                    break;
                case ')':
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        cal(nums, ops);
                    }
                    ops.removeLast();
                    ind++;
                    break;
                case '+':
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        cal(nums, ops);
                    }
                    ops.addLast('+');
                    ind++;
                    break;
                case '-':
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        cal(nums, ops);
                    }
                    ops.addLast('-');
                    ind++;
                    break;
                case '*':
                case '/':
                    while (!ops.isEmpty() && (ops.peekLast() == '*' || ops.peekLast() == '/')) {
                        cal(nums, ops);
                    }

                    ops.addLast(s.charAt(ind));
                    ind++;
                    break;
                default:
                    int n = 0;
                    while (ind < s.length() && Character.isDigit(s.charAt(ind))) {
                        n = n * 10 + s.charAt(ind) - '0';
                        ind++;
                    }
                    nums.addLast(n);
                    break;
            }
        }

        while (!ops.isEmpty()) {
            cal(nums, ops);
        }
        return nums.removeLast();
    }

    private void cal(Deque<Integer> nums, Deque<Character> ops) {
        int y = nums.removeLast();
        int x = nums.removeLast();
        int n = 0;
        switch (ops.removeLast()) {
            case '+':
                n = x + y;
                break;
            case '-':
                n = x - y;
                break;
            case '*':
                n = x * y;
                break;
            case '/':
                n = x / y;
                break;
        }
        nums.addLast(n);
    }
}
