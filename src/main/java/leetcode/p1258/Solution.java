package leetcode.p1258;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/16
 */
public class Solution {

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        UnionFind uf = new UnionFind();
        for (List<String> arr : synonyms) {
            uf.connect(arr.get(0), arr.get(1));
        }

        List<String> list = new ArrayList<>();
        int ind = 0;
        while (ind < text.length()) {
            if (text.charAt(ind) == ' ') {
                ind++;
                continue;
            }

            int pre = ind;
            while (ind < text.length() && text.charAt(ind) != ' ') {
                ind++;
            }
            String item = text.substring(pre, ind);
            uf.connect(item, item);
            list.add(item);
        }
        uf.init();

        List<String> res = new ArrayList<>();
        backtrack(list, 0, new ArrayDeque<>(), uf, res);
        return res;
    }

    private void backtrack(List<String> list, int i, Deque<String> path, UnionFind uf, List<String> res) {
        if (i == list.size()) {
            StringBuilder sb = new StringBuilder();
            for (String str : path) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(str);
            }
            res.add(sb.toString());
            return;
        }

        String cur = list.get(i);
        for (String str : uf.getStrList()) {
            if (uf.isConnected(cur, str)) {
                path.addLast(str);
                backtrack(list, i + 1, path, uf, res);
                path.removeLast();
            }
        }
    }

    private class UnionFind {

        private Map<String, Integer> idMap;

        private Map<Integer, Integer> parent;

        private List<String> strList;

        private int id;

        public UnionFind() {
            idMap = new HashMap<>();
            parent = new HashMap<>();
            strList = new ArrayList<>();
        }

        public void connect(String s1, String s2) {
            int p1 = getParent(getId(s1));
            int p2 = getParent(getId(s2));
            if (p1 != p2) {
                parent.put(p1, p2);
            }
        }

        public boolean isConnected(String s1, String s2) {
            return getParent(getId(s1)) == getParent(getId(s2));
        }

        public List<String> getStrList() {
            return strList;
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
            strList.add(s);
            return newId;
        }

        private void init() {
            strList.sort(String::compareTo);
        }
    }
}
