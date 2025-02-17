package com.catxu.leetcode.question71;

import java.util.Stack;

/**
 * 71. Simplify Path
 * <p>
 * You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.
 * <p>
 * The rules of a Unix-style file system are as follows:
 * <pre>
 * A single period '.' represents the current directory.
 * A double period '..' represents the previous/parent directory.
 * Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
 * Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
 * </pre>
 * The simplified canonical path should follow these rules:
 * <pre>
 * The path must start with a single slash '/'.
 * Directories within the path must be separated by exactly one slash '/'.
 * The path must not end with a slash '/', unless it is the root directory.
 * The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
 * Return the simplified canonical path.
 * </pre>
 * Example 1:
 * <pre>
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation:
 * The trailing slash should be removed.
 * </pre>
 * Example 2:
 * <pre>
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation:
 * Multiple consecutive slashes are replaced by a single one.
 * </pre>
 * Example 3:
 * <pre>
 * Input: path = "/home/user/Documents/../Pictures"
 * Output: "/home/user/Pictures"
 * Explanation:
 * A double period ".." refers to the directory up a level (the parent directory).
 * </pre>
 * Example 4:
 * <pre>
 * Input: path = "/../"
 * Output: "/"
 * Explanation:
 * Going one level up from the root directory is not possible.
 * </pre>
 * Example 5:
 * <pre>
 * Input: path = "/.../a/../b/c/../d/./"
 * Output: "/.../b/d"
 * Explanation:
 * "..." is a valid name for a directory in this problem.
 * </pre>
 * <p>
 * Constraints:
 * <pre>
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid absolute Unix path.
 * </pre>
 */
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] paths = path.split("/");
        for (String p : paths) {
            if (!p.isEmpty()) {
                stack.push(p);
            }
        }
        sb.append("/");
        while (!stack.isEmpty()) {
            String p = stack.pop();
            if (p.equals(".") || p.equals("..")) {
                if (!p.equals(".")) {
                    sb.delete(sb.lastIndexOf("/") + 1, sb.length());
                }
                continue;
            }
            sb.append(p).append("/");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/home/"));
        System.out.println(new Solution().simplifyPath("/home//foo/"));
    }
}
