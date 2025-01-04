package com.catxu.leetcode.question729;

/**
 * 729. My Calendar I
 */
class MyCalendar {

    static class SegmentTree {
        private final int start;
        private final int end;
        private SegmentTree left;
        private SegmentTree right;
        public SegmentTree(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean insert(int startTime, int endTime) {
            SegmentTree cur = this;
            while (true) {
                if (endTime <= cur.start) {
                    if (cur.left == null) {
                        cur.left = new SegmentTree(startTime, endTime);
                        return true;
                    }
                    cur = cur.left;
                } else if (startTime >= cur.end) {
                    if (cur.right == null) {
                        cur.right = new SegmentTree(startTime, endTime);
                        return true;
                    }
                    cur = cur.right;
                } else {
                    return false;
                }
            }
        }
    }

    private SegmentTree root;

    public MyCalendar() {
    }

    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new SegmentTree(startTime, endTime);
            return true;
        }
        return root.insert(startTime, endTime);
    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 25));
        System.out.println(calendar.book(20, 30));
        System.out.println(calendar.book(15, 16));
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(8, 19));
    }
}
