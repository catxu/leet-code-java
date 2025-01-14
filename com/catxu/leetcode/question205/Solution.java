package com.catxu.leetcode.question205;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>(), t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            // 对于已有映射 a -> s2t[a]，若和当前字符映射 a -> b 不匹配，
            // 说明有一对多的映射关系，则返回 false ；
            // 对于映射 b -> a 也同理
            if (s2t.containsKey(a) && s2t.get(a) != b ||
                    t2s.containsKey(b) && t2s.get(b) != a)
                return false;
            s2t.put(a, b);
            t2s.put(b, a);
        }
        return true;


        //        var sMapT = new int[128];
        //        var tMapS = new int[128];
        //        for (int i = 0; i < s.length(); i++) {
        //            int a = s.charAt(i), b = t.charAt(i);
        //            // a -> b <=> b -> a 需要一一映射
        //            if (sMapT[a] != 0 && sMapT[a] != b ||
        //                    tMapS[b] != 0 && tMapS[b] != a) return false;
        //            sMapT[a] = b;
        //            tMapS[b] = a;
        //        }
        //        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("egg", "add"));
        System.out.println(new Solution().isIsomorphic("foo", "bar"));
        System.out.println(new Solution().isIsomorphic("paper", "title"));
        System.out.println(new Solution().isIsomorphic("dzd", "aag"));
    }
}
