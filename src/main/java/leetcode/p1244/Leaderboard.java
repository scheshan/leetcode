package leetcode.p1244;

import java.util.*;

/**
 * Leaderboard
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Leaderboard {

    private Map<Integer, Integer> userMap;

    private TreeMap<Integer, Set<Integer>> scoreMap;

    public Leaderboard() {
        userMap = new HashMap<>();
        scoreMap = new TreeMap<>();
    }

    public void addScore(int playerId, int score) {
        if (userMap.containsKey(playerId)) {
            int oldScore = userMap.get(playerId);
            removeScore(playerId, oldScore);
            score += oldScore;
        }
        userMap.put(playerId, score);
        scoreMap.compute(score, (k, v) -> {
            if (v == null) {
                v = new HashSet<>();
            }
            v.add(playerId);
            return v;
        });
    }

    public int top(int K) {
        int res = 0;

        for (Map.Entry<Integer, Set<Integer>> entry : scoreMap.descendingMap().entrySet()) {
            int cnt = entry.getValue().size();
            res += Math.min(K, cnt) * entry.getKey();
            K -= Math.min(K, cnt);

            if (K == 0) {
                break;
            }
        }
        return res;
    }

    public void reset(int playerId) {
        int score = userMap.get(playerId);
        removeScore(playerId, score);
        userMap.remove(playerId);
    }

    private void removeScore(int playerId, int score) {
        Set<Integer> set = scoreMap.get(score);
        set.remove(playerId);
        if (set.size() == 0) {
            scoreMap.remove(score);
        }
    }
}
