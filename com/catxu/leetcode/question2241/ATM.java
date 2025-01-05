package com.catxu.leetcode.question2241;

import java.util.Arrays;

/**
 * 2241. Design an ATM Machine
 */
class ATM {

    private final int[] banknotes;
    private final int[] values;

    public ATM() {
        this.values = new int[]{20, 50, 100, 200, 500};
        this.banknotes = new int[values.length];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < values.length; i++) {
            banknotes[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] usedBanknotes = new int[5];
        for (int i = values.length - 1; i >= 0; i--) {
            if (amount == 0) {
                break;
            }
            int count = Math.min(amount / values[i], banknotes[i]);
            amount -= (count * values[i]);
            usedBanknotes[i] = count;
        }
        if (amount > 0) {
            return new int[]{-1};
        }
        for (int i = 0; i < values.length; i++) {
            banknotes[i] -= usedBanknotes[i];
        }
        return usedBanknotes;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{0, 0, 1, 2, 1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        atm.deposit(new int[]{0, 1, 0, 1, 1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        System.out.println(Arrays.toString(atm.withdraw(550)));

    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
