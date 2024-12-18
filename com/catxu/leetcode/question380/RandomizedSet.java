package com.catxu.leetcode.question380;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)
 * <p>
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * <p>
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * <p>
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * <p>
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * <p>
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input
 *
 * <pre>
 *     {@code
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 *     }
 * </pre>
 * <p>
 * Output
 * <p>
 * <pre>
 *     {@code
 * [null, true, false, true, 2, true, false, 2]
 *  }
 *  </pre>
 * Explanation
 * <pre>
 *     {@code
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 *     }
 * </pre>
 * <p>
 * Constraints:
 * <p>
 * -2<pre>31</pre> <= val <= 2<pre>31</pre> - 1
 * <p>
 * At most 2 * 10<pre>5</pre> calls will be made to insert, remove, and getRandom.
 * <p>
 * There will be at least one element in the data structure when getRandom is called.
 */
class RandomizedSet {

    private final Map<Integer, Integer> valAndIndexMap;
    private final Integer[] vals;
    private final Random random;
    private int size;

    public RandomizedSet() {
        valAndIndexMap = new HashMap<>();
        vals = new Integer[2_00000];
        random = new Random();
        size = 0;
    }

    public boolean insert(int val) {
        if (valAndIndexMap.containsKey(val)) {
            return false;
        }
        valAndIndexMap.put(val, size);
        vals[size] = val;
        size += 1;
        return true;
    }

    public boolean remove(int val) {
        // 从map中移除 val，从 list 中将最后一个值与被移除值替换，将最后一个值删除
        if (!valAndIndexMap.containsKey(val)) {
            return false;
        }
        Integer removedIndex = valAndIndexMap.remove(val);
        if (removedIndex != size - 1) {
            vals[removedIndex] = vals[size - 1];
            // 更新lastVal在map中的索引
            valAndIndexMap.put(vals[size - 1], removedIndex);
        }
        vals[size - 1] = null;
        size -= 1;
        return true;
    }

    public int getRandom() {
        return vals[random.nextInt(size)];
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());

//        System.out.println(obj.insert(0));
//        System.out.println(obj.insert(1));
//        System.out.println(obj.remove(0));
//        System.out.println(obj.insert(2));
//        System.out.println(obj.remove(1));

//        System.out.println(obj.remove(0));
//        System.out.println(obj.remove(0));
//        System.out.println(obj.insert(0));
//        System.out.println(obj.getRandom());
//        System.out.println(obj.remove(0));
//        System.out.println(obj.insert(0));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
