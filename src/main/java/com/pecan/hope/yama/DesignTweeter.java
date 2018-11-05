package com.pecan.hope.yama;

import java.util.*;

/**
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see
 * the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet. getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the
 * user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself.
 * Tweets must be ordered from most recent to least recent. follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee. Example:
 * <p>
 * Twitter twitter = new Twitter();
 * <p>
 * // User 1 posts a new tweet (id = 5). twitter.postTweet(1, 5);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5]. twitter.getNewsFeed(1);
 * <p>
 * // User 1 follows user 2. twitter.follow(1, 2);
 * <p>
 * // User 2 posts a new tweet (id = 6). twitter.postTweet(2, 6);
 * <p>
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. // Tweet id 6 should precede tweet id 5
 * because it is posted after tweet id 5. twitter.getNewsFeed(1);
 * <p>
 * // User 1 unfollows user 2. twitter.unfollow(1, 2);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5], // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */
public class DesignTweeter {
    final int FEED_LIMIT = 10;
    // increment everytime there's new tweet
    Integer timestamp = 0;
    // user - following, user id - user id set
    Map<Integer, Set<Integer>> following = new HashMap<>();
    // user - tweets, user id - tweet id list
    Map<Integer, List<Tweet>> tweets = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public DesignTweeter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(userId, tweetId, timestamp++);
        // check if it's first time user tweets
        if (tweets.containsKey(userId)) {


            List<Tweet> currentTweets = tweets.get(userId);
            // add latest to tail
            currentTweets.add(tweet);

            if (currentTweets.size() > FEED_LIMIT) {
                // remove head if size reaches
                currentTweets.remove(0);
            }
        } else {
            follow(userId, userId);
            List<Tweet> currentTweets = new LinkedList<>();
            currentTweets.add(tweet);
            tweets.put(userId, currentTweets);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users
     * who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {

        Set<Integer> followees = following.get(userId);

        // user has not followed or posted
        if (followees == null) {
            return new LinkedList<>();
        }


        PriorityQueue<Tweet> pq = new PriorityQueue<>(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet t1, Tweet t2) {
                return t1.timestamp.compareTo(t2.timestamp);
            }
        });

        for (Integer followee : followees) {
            List<Tweet> followeeTweets = tweets.get(followee);
            if (followeeTweets == null) continue;

            for (int i = followeeTweets.size() - 1; i >= 0; i--) {
                int tweetTimestamp = followeeTweets.get(i).timestamp;
                if (pq.size() < FEED_LIMIT) {
                    pq.offer(followeeTweets.get(i));
                    continue;
                }

                int earliestTs = pq.peek().timestamp;
                if (earliestTs > tweetTimestamp) break;

                pq.poll();
                pq.offer(followeeTweets.get(i));

            }
        }

        List<Integer> res = new LinkedList<Integer>();

        while (!pq.isEmpty()) {
            res.add(0, pq.poll().tweetId);
        }

        return res;

    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        // make sure user follows itself
        if (!following.containsKey(followerId)) {
            Set<Integer> followee = new HashSet<>();
            followee.add(followerId);
            following.put(followerId, followee);
        }

        following.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        // unfollow itself is not allowed
        if (followerId == followeeId) return;

        if (!following.containsKey(followerId)) return;

        following.get(followerId).remove(followeeId);
    }

    static class Tweet {
        Integer userId;
        Integer tweetId;
        Integer timestamp;

        public Tweet(int userId, int tweetId, int timestamp) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
}
