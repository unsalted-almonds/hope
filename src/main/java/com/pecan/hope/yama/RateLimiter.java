package com.pecan.hope.yama;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * [LeetCode] Logger Rate Limiter 记录速率限制器
 * <p>
 * <p>
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if
 * and only if it is not printed in the last 10 seconds.
 * <p>
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given
 * timestamp, otherwise returns false.
 * <p>
 * It is possible that several messages arrive roughly at the same time.
 * <p>
 * Example:
 * <p>
 * Logger logger = new Logger();
 * <p>
 * // logging string "foo" at timestamp 1 logger.shouldPrintMessage(1, "foo"); returns true;
 * <p>
 * // logging string "bar" at timestamp 2 logger.shouldPrintMessage(2,"bar"); returns true;
 * <p>
 * // logging string "foo" at timestamp 3 logger.shouldPrintMessage(3,"foo"); returns false;
 * <p>
 * // logging string "bar" at timestamp 8 logger.shouldPrintMessage(8,"bar"); returns false;
 * <p>
 * // logging string "foo" at timestamp 10 logger.shouldPrintMessage(10,"foo"); returns false;
 * <p>
 * // logging string "foo" at timestamp 11 logger.shouldPrintMessage(11,"foo"); returns true;
 * <p>
 * Credits: Special thanks to @memoryless for adding this problem and creating all test cases.
 */
public class RateLimiter {

    Set<String> lastTenSecondsPrinted = new HashSet<>();
    Map<Integer, Set<String>> timeBuckets = new HashMap<>();
    //List<Set<String>> timeBucketArray = new ArrayList<>(10);
    Set<String>[] timeBucketArray = new Set[10];

    int bucketHead = 0;
    Map<String, Integer> map = new HashMap<>();
    int limiter = 10;

    public static void main(String[] args) {
        RateLimiter test = new RateLimiter();
        System.out.println(test.shouldPrintMessage(1, "foo"));
        System.out.println(test.shouldPrintMessage(2, "bar"));
        System.out.println(test.shouldPrintMessage(3, "foo"));
        System.out.println(test.shouldPrintMessage(8, "bar"));
        System.out.println(test.shouldPrintMessage(10, "foo"));
        System.out.println(test.shouldPrintMessage(11, "foo"));
    }

    public boolean shouldPrintMessage2(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        }

        if (timestamp - map.get(message) >= limiter) {
            map.put(message, timestamp);
            return true;
        }


        return false;
    }

    public boolean shouldPrintMessage(int timestamp, String log) {

        int newHead = timestamp - limiter + 1;
        while (bucketHead < newHead) {
            Set<String> bucket = timeBucketArray[bucketHead % limiter];
            if (bucket != null) {
                lastTenSecondsPrinted.removeAll(bucket);
            }
            bucketHead++;
        }

        if (lastTenSecondsPrinted.contains(log)) {
            return false;
        }

        lastTenSecondsPrinted.add(log);

        if (timeBucketArray[timestamp % limiter] == null) {
            Set<String> bucket = new HashSet<>();
            bucket.add(log);
            timeBucketArray[timestamp % limiter] = bucket;
        } else {
            timeBucketArray[timestamp % limiter].add(log);
        }

        return true;
    }

    public boolean shouldPrintMessage1(int timestamp, String log) {

        int newHead = timestamp - limiter + 1;
        while (bucketHead < newHead) {
            Set<String> bucket = timeBuckets.remove(bucketHead);
            if (bucket != null) {
                lastTenSecondsPrinted.removeAll(bucket);
            }
            bucketHead++;
        }

        if (lastTenSecondsPrinted.contains(log)) {
            return false;
        }

        lastTenSecondsPrinted.add(log);
        if (timeBuckets.containsKey((timestamp))) {
            timeBuckets.get(timestamp).add(log);
        } else {
            Set<String> bucket = new HashSet<>();
            bucket.add(log);
            timeBuckets.put(timestamp, bucket);
        }

        return true;
    }

}
