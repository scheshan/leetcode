package l1209;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/1
 */
public class Solution {

    private class Item {

        char ch;

        int count;

        public Item(char ch) {
            this.ch = ch;
            count = 1;
        }
    }

    public String removeDuplicates(String s, int k) {
        if (k == 1) {
            return "";
        }

        Deque<Item> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!deque.isEmpty() && deque.peekLast().ch == ch) {
                Item item = deque.removeLast();
                item.count++;
                if (item.count < k) {
                    deque.addLast(item);
                }
            } else {
                deque.addLast(new Item(ch));
            }
        }

        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            Item item = deque.removeFirst();

            for (int i = 0; i < item.count; i++) {
                res.append(item.ch);
            }
        }

        return res.toString();
    }
}
