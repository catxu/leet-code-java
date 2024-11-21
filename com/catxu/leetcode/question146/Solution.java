package com.catxu.leetcode.question146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * <p>
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * <p>
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * <p>
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * <p>
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input
 * <p>
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * <p>
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * <p>
 * Output
 * <p>
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * Explanation
 * <p>
 * LRUCache lRUCache = new LRUCache(2);
 * <p>
 * lRUCache.put(1, 1); // cache is {1=1}
 * <p>
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * <p>
 * lRUCache.get(1);    // return 1
 * <p>
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * <p>
 * lRUCache.get(2);    // returns -1 (not found)
 * <p>
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * <p>
 * lRUCache.get(1);    // return -1 (not found)
 * <p>
 * lRUCache.get(3);    // return 3
 * <p>
 * lRUCache.get(4);    // return 4
 * <p>
 * Constraints:
 * <p>
 * 1 <= capacity <= 3000
 * <p>
 * 0 <= key <= 10<sup>4</sup>
 * <p>
 * 0 <= value <= 10<sup>5</sup>
 * <p>
 * At most 2 * 10<sup>5</sup> calls will be made to get and put.
 */
class LRUCache extends LinkedHashMap<Integer, Integer> {

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, .75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(2));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */