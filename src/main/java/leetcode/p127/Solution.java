package leetcode.p127;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    private Map<String, Integer> wordMap = new HashMap<>();

    private List<List<Integer>> edges = new ArrayList<>();

    private int wordId;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);

        if (!wordMap.containsKey(endWord)) {
            return 0;
        }
        return bfs(wordMap.get(beginWord), wordMap.get(endWord));
    }

    private int bfs(int begin, int end) {
        boolean[] visit = new boolean[wordId];
        Queue<Integer> queue = new LinkedList<>();
        addQueue(queue, begin, visit);

        int step = 1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int id = queue.remove();
                if (id == end) {
                    return step / 2;
                }

                for (int next : edges.get(id)) {
                    addQueue(queue, next, visit);
                }
            }
        }

        return 0;
    }

    private void addEdge(String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char t = arr[i];
            arr[i] = '*';
            connect(word, new String(arr));
            arr[i] = t;
        }
    }

    private void connect(String a, String b) {
        int id1 = getWordId(a);
        int id2 = getWordId(b);

        edges.get(id1).add(id2);
        edges.get(id2).add(id1);
    }

    private int getWordId(String str) {
        int id;
        if (!wordMap.containsKey(str)) {
            id = wordId++;
            wordMap.put(str, id);
            edges.add(new ArrayList<>());
        } else {
            id = wordMap.get(str);
        }
        return id;
    }

    private void addQueue(Queue<Integer> queue, int id, boolean[] visit) {
        if (visit[id]) {
            return;
        }
        visit[id] = true;
        queue.add(id);
    }
}
