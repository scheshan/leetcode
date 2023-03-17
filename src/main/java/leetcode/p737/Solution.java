package leetcode.p737;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/16
 */
public class Solution {

    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        UnionFind uf = new UnionFind();
        for (List<String> pair : similarPairs) {
            uf.connect(pair.get(0), pair.get(1));
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (!uf.isConnect(sentence1[i], sentence2[i])) {
                return false;
            }
        }
        return true;
    }

    private class UnionFind {

        Map<String, Integer> idMap;

        Map<Integer, Integer> parent;

        private int id;

        public UnionFind() {
            idMap = new HashMap<>();
            parent = new HashMap<>();
        }

        public void connect(String s1, String s2) {
            int p1 = getParent(getId(s1));
            int p2 = getParent(getId(s2));
            if (p1 != p2) {
                parent.put(p1, p2);
            }
        }

        public boolean isConnect(String s1, String s2) {
            return getParent(getId(s1)) == getParent(getId(s2));
        }

        private int getParent(int i) {
            while (i != parent.get(i)) {
                parent.put(i, parent.get(parent.get(i)));
                i = parent.get(i);
            }
            return i;
        }

        private int getId(String s) {
            if (idMap.containsKey(s)) {
                return idMap.get(s);
            }

            int newId = id++;
            idMap.put(s, newId);
            parent.put(newId, newId);
            return newId;
        }
    }
}
