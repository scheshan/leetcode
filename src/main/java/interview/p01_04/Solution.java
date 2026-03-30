package interview.p01_04;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean canPermutePalindrome(String s) {
        int wordCount = 0;
        Set<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (!set.contains(ch)) {
                set.add(ch);
                wordCount++;
            } else {
                set.remove(ch);
                wordCount--;
            }
        }

        return wordCount < 2;
    }
}
