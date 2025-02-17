package com.catxu.leetcode.question30;

import java.util.*;

/**
 * 30. Substring with Concatenation of All Words
 * <p>
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 * <p>
 * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
 * <p>
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
 * <p>
 * Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 * <p>
 * Example 1:
 * <pre>
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation:
 * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
 * </pre>
 * Example 2:
 * <pre>
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Explanation:
 * There is no concatenated substring.
 * </pre>
 * Example 3:
 * <pre>
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 * Explanation:
 * The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
 * The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
 * The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
 * </pre>
 * Constraints:
 * <pre>
 * 1 <= s.length <= 10<sup>4</sup>
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * s and words[i] consist of lowercase English letters.
 * </pre>
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        int lenWord = words[0].length();
        int n = words.length;
        int totalLen = lenWord * n;
        int lenS = s.length();

        if (lenS < totalLen) {
            return result;
        }

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.merge(word, 1, Integer::sum);
        }
        int uniqueWords = wordCount.size();

        // 遍历所有可能的起始余数 (0 到 lenWord-1)
        for (int r = 0; r < lenWord; r++) {
            int k = (lenS - r) / lenWord; // 该余数下可能的单词数量
            if (k < n) break;

            Map<String, Integer> currentMap = new HashMap<>();
            // 当前窗口内，匹配的word数量（要求word在dict中且wordCount == dict中word的数量）
            int valid = 0;
            int left = 0;

            for (int right = 0; right < k; right++) {
                // 计算当前单词的起始位置
                int wordStart = r + right * lenWord;
                int wordEnd = wordStart + lenWord;
                if (wordEnd > s.length()) break; // 防止越界
                String word = s.substring(wordStart, wordEnd);

                // 遇到无效单词时重置窗口
                if (!wordCount.containsKey(word)) {
                    currentMap.clear();
                    valid = 0;
                    left = right + 1;
                    continue;
                }

                // 更新当前窗口的单词计数
                currentMap.merge(word, 1, Integer::sum);
                if (currentMap.get(word).equals(wordCount.get(word))) {
                    valid++;
                } else if (currentMap.get(word) == wordCount.get(word) + 1) {
                    valid--;
                }

                // 维护窗口大小为n个单词
                while (right - left + 1 > n) {
                    int leftWordStart = r + left * lenWord;
                    String leftWord = s.substring(leftWordStart, leftWordStart + lenWord);

                    currentMap.merge(leftWord, -1, Integer::sum);
                    if (currentMap.get(leftWord).equals(wordCount.get(leftWord) - 1)) {
                        valid--;
                    } else if (currentMap.get(leftWord).equals(wordCount.get(leftWord))) {
                        valid++;
                    }

                    left++;
                }

                // 检查窗口有效性
                if (right - left + 1 == n && valid == uniqueWords) {
                    result.add(r + left * lenWord);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("barfoobarthefoobarman", new String[]{"foo", "bar"}));
        System.out.println(new Solution().findSubstring("wordgoodgoodgoodwordbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(new Solution().findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(new Solution().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
    }
}
