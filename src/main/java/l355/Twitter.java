package l355;

import java.util.*;

/**
 * Twitter
 *
 * @author heshan
 * @date 2020/4/13
 */
class Twitter {

    private Map<Integer, LinkedList<Post>> posts;

    private Map<Integer, Set<Integer>> follows;

    private int time;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        posts = new HashMap<>();
        follows = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        LinkedList<Post> list = posts.get(userId);
        if (list == null) {
            list = new LinkedList<>();
            posts.put(userId, list);
        }
        if (list.size() > 10) {
            list.removeLast();
        }
        Post p = new Post(tweetId);
        list.addFirst(p);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> set = follows.get(userId);
        if (set == null) {
            set = new HashSet<>();
        }
        set.add(userId);

        PriorityQueue<PostList> queue = new PriorityQueue<>(new Comparator<PostList>() {
            @Override
            public int compare(PostList o1, PostList o2) {
                return Long.compare(o2.current.time, o1.current.time);
            }
        });
        for (int id : set) {
            LinkedList<Post> list = posts.get(id);
            if (list != null) {
                queue.add(new PostList(list));
            }
        }

        int i = 0;
        List<Integer> res = new ArrayList<>(10);
        while (i < 10 && !queue.isEmpty()) {
            PostList p = queue.remove();
            res.add(p.current.id);

            if (p.hasNext()) {
                p.next();
                queue.add(p);
            }
            i++;
        }

        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = follows.get(followerId);
        if (set == null) {
            set = new HashSet<>();
            follows.put(followerId, set);
        }
        set.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = follows.get(followerId);
        if (set != null) {
            set.remove(followeeId);
        }
    }

    private class PostList {

        private Iterator<Post> posts;

        private Post current;

        public PostList(LinkedList<Post> list) {
            this.posts = list.iterator();
            current = posts.next();
        }

        private boolean hasNext() {
            return posts.hasNext();
        }

        private void next() {
            current = posts.next();
        }
    }

    private class Post {

        private int id;

        private int time;

        public Post(int id) {
            this.id = id;
            time = Twitter.this.time++;
        }
    }
}
