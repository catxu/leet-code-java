package com.catxu.leetcode.question68;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 * <p>
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 * <p>
 * Note:
 * <p>
 * A word is defined as a character sequence consisting of non-space characters only.
 * <p>
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * <p>
 * The input array words contains at least one word.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * <p>
 * Output:
 *
 * <pre>
 *     {@code
 *     [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *     }
 * </pre>
 * <p>
 * Example 2:
 * <p>
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * <p>
 * Output:
 *
 * <pre>
 * {@code
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * }
 * </pre>
 * <p>
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * <p>
 * Note that the second line is also left-justified because it contains only one word.
 * <p>
 * Example 3:
 * <p>
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * <p>
 * Output:
 *
 * <pre>{@code
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 * }
 * </pre>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 300
 * <p>
 * 1 <= words[i].length <= 20
 * <p>
 * words[i] consists of only English letters and symbols.
 * <p>
 * 1 <= maxWidth <= 100
 * <p>
 * words[i].length <= maxWidth
 */
class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = groupLines(words, maxWidth);
        return justifyLine(lines, maxWidth);
    }

    private List<String> justifyLine(List<List<String>> lines, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < lines.size() - 1; i++) {
            List<String> line = lines.get(i);
            int spaceCount = maxWidth - line.stream().mapToInt(String::length).sum();
            // 特殊处理：一行只有一个单词
            if (line.size() == 1) {
                res.add(line.get(0) + " ".repeat(spaceCount));
                continue;
            }
            int spaceBetween = spaceCount / (line.size() - 1);
            int extraSpace = spaceCount % (line.size() - 1);
            StringBuilder justified = new StringBuilder();
            for (int j = 0; j < line.size() - 1; j++) {
                justified.append(line.get(j)).append(" ".repeat(spaceBetween + (j < extraSpace ? 1 : 0)));
            }
            justified.append(line.get(line.size() - 1));
            res.add(justified.toString());
        }
        String lastLine = String.join(" ", lines.get(lines.size() - 1));
        lastLine = String.format("%-" + maxWidth + "s", lastLine);
        res.add(lastLine);
        return res;
    }

    private List<List<String>> groupLines(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        int curLength = 0;
        List<String> wordsInLine = new ArrayList<>();
        for (String word : words) {
            // 计算加入新 word 之后，是否超过 maxWidth，需包含基本空格数即 wordsInLine.size()
            if (curLength + wordsInLine.size() + word.length() > maxWidth) {
                lines.add(new ArrayList<>(wordsInLine));
                wordsInLine.clear();
                curLength = 0;
            }
            wordsInLine.add(word);
            curLength += word.length();
        }
        lines.add(wordsInLine);
        return lines;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(s.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(s.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));
    }
}
