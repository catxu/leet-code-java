package com.catxu.leetcode.question721;

import java.util.*;

/**
 * 721. Accounts Merge
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, List<Integer>> email2Idx = new HashMap<>(); // email and occurs node indices
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                email2Idx.computeIfAbsent(account.get(j), k -> new LinkedList<>()).add(i);
            }
        }

        boolean[] vis = new boolean[n];
        List<List<String>> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            Set<String> emails = new HashSet<>();
            dfs(i, accounts, emails, vis, email2Idx);
            List<String> t = new LinkedList<>(emails);
            Collections.sort(t);
            t.addFirst(accounts.get(i).getFirst());
            ans.add(t);
        }
        return ans;
    }

    private void dfs(int i, List<List<String>> accounts, Set<String> emails, boolean[] vis, Map<String, List<Integer>> email2Idx) {
        vis[i] = true;
        List<String> account = accounts.get(i);
        for (int j = 1; j < account.size(); j++) {
            String email = account.get(j);
            if (emails.add(email)) {
                for (int idx : email2Idx.get(email)) {
                    if (!vis[idx]) dfs(idx, accounts, emails, vis, email2Idx);
                }
            }
        }
    }
}
