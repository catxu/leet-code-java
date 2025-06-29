package com.catxu.leetcode.question913;

import java.util.*;

/**
 * 913. Cat and Mouse
 */
class Solution {
    // dp[mousePos][catPos][turn]
    // turn: 0 for mouse, 1 for cat
    // Result: 0 for Draw, 1 for Mouse Win, 2 for Cat Win
    int[][][] dp;
    int[][] g;
    int n; // Number of nodes

    // top-down 从未知推向已知
    public int catMouseGame(int[][] graph) {
        this.g = graph;
        this.n = graph.length;
        // Max turns can be estimated as 2 * N * N to detect cycles for sure
        // We can use a more precise state to manage draws implicitly.
        // Instead of maxTurns, we rely on the memoization state:
        // -1: Not visited
        // 0: Draw (or currently visiting, potential draw)
        // 1: Mouse Win
        // 2: Cat Win
        this.dp = new int[n][n][2];

        // Initialize dp array with -1 (unvisited)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return getWinner(1, 2, 0); // Start: mouse at 1, cat at 2, mouse's turn
    }

    private int getWinner(int mousePos, int catPos, int turn) {
        // Base cases
        if (turn == 2 * n) return 0;
        if (mousePos == 0) { // Mouse reached hole
            return 1; // Mouse wins
        }
        if (catPos == mousePos) { // Cat caught mouse
            return 2; // Cat wins
        }

        // Check if this state has been computed
        if (dp[mousePos][catPos][turn] != -1) {
            return dp[mousePos][catPos][turn];
        }

        // switch turns
        boolean mouseTurn = turn >> 1 == 0;

        if (mouseTurn) { // Mouse's turn
            // Mouse wants to win (1), if not possible, draw (0), if not possible, cat wins (2)
            int defaultResult = 2; // Assume cat wins if mouse cannot force a win or draw

            for (int nextMousePos : g[mousePos]) {
                int result = getWinner(nextMousePos, catPos, turn + 1);
                if (result == 1) { // Mouse can win
                    return dp[mousePos][catPos][turn] = 1;
                }
                if (result == 0) { // Mouse can force a draw
                    defaultResult = 0; // Update defaultResult to draw
                }
            }
            return dp[mousePos][catPos][turn] = defaultResult;
        } else { // Cat's turn
            // Cat wants to win (2), if not possible, draw (0), if not possible, mouse wins (1)
            int defaultResult = 1; // Assume mouse wins if cat cannot force a win or draw

            for (int nextCatPos : g[catPos]) {
                if (nextCatPos == 0) continue; // Cat cannot enter hole 0
                int result = getWinner(mousePos, nextCatPos, turn + 1);
                if (result == 2) { // Cat can win
                    return dp[mousePos][catPos][turn] = 2;
                }
                if (result == 0) { // Cat can force a draw
                    defaultResult = 0; // Update defaultResult to draw
                }
            }
            return dp[mousePos][catPos][turn] = defaultResult;
        }
    }

    class BottomUp {

        public static final int HOLE = 0, MOUSE_START = 1, CAT_START = 2;
        public static final int MOUSE_TURN = 0, CAT_TURN = 1;
        public static final int UNKNOWN = 0, MOUSE_WIN = 1, CAT_WIN = 2;
        private int n;
        private int[][] graph;
        private int[][][] degrees;
        private int[][][] results;

        public int catMouseGame(int[][] graph) {
            this.n = graph.length;
            this.graph = graph;
            this.degrees = new int[n][n][2];
            this.results = new int[n][n][2];

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    degrees[i][j][MOUSE_TURN] = graph[i].length;
                    degrees[i][j][CAT_TURN] = graph[j].length;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j : graph[HOLE]) {
                    degrees[i][j][CAT_TURN]--;
                }
            }

            Queue<int[]> queue = new ArrayDeque<>();
            for (int i = 1; i < n; i++) {
                results[i][i][MOUSE_TURN] = CAT_WIN;
                results[i][i][CAT_TURN] = CAT_WIN;
                queue.offer(new int[]{i, i, MOUSE_TURN});
                queue.offer(new int[]{i, i, CAT_TURN});
            }
            for (int j = 1; j < n; j++) {
                results[HOLE][j][MOUSE_TURN] = MOUSE_WIN;
                results[HOLE][j][CAT_TURN] = MOUSE_WIN;
                queue.offer(new int[]{HOLE, j, MOUSE_TURN});
                queue.offer(new int[]{HOLE, j, CAT_TURN});
            }

            while (!queue.isEmpty()) {
                int[] state = queue.poll();
                int mouse = state[0], cat = state[1], turn = state[2];
                int result = results[mouse][cat][turn];
                List<int[]> prevStates = getPrevStates(mouse, cat, turn);
                for (int[] prevState : prevStates) {
                    int prevMouse = prevState[0], prevCat = prevState[1], prevTurn = prevState[2];
                    if (results[prevMouse][prevCat][prevTurn] == UNKNOWN) {
                        boolean winState = (result == MOUSE_WIN && prevTurn == MOUSE_TURN) || (result == CAT_WIN && prevTurn == CAT_TURN);
                        if (winState) {
                            results[prevMouse][prevCat][prevTurn] = result;
                            queue.offer(new int[]{prevMouse, prevCat, prevTurn});
                        } else {
                            degrees[prevMouse][prevCat][prevTurn]--;
                            if (degrees[prevMouse][prevCat][prevTurn] == 0) {
                                results[prevMouse][prevCat][prevTurn] = result;
                                queue.offer(new int[]{prevMouse, prevCat, prevTurn});
                            }
                        }
                    }
                }
            }

            return results[MOUSE_START][CAT_START][MOUSE_TURN];
        }


        private List<int[]> getPrevStates(int mouse, int cat, int turn) {
            List<int[]> prevStates = new ArrayList<>();
            int prevTurn = turn == MOUSE_TURN ? CAT_TURN : MOUSE_TURN;
            if (prevTurn == CAT_TURN) {
                for (int prevCat : graph[cat]) {
                    if (prevCat != HOLE) {
                        prevStates.add(new int[]{mouse, prevCat, prevTurn});
                    }
                }
            } else {
                for (int prevMouse : graph[mouse]) {
                    prevStates.add(new int[]{prevMouse, cat, prevTurn});
                }
            }
            return prevStates;
        }
    }
}
