package com.catxu.leetcode.question;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EbbinghausReviewPlanWithIntervals {

    public static void generateReviewPlan(int start, int end, int[] intervals, String filePath) {
        // 计算总题目数
        int totalQuestions = end - start + 1;

        // 创建一个List来存储题目序号
        List<Integer> questions = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            questions.add(i);
        }

        // 打乱题目顺序
        Collections.shuffle(questions);

        // 创建文件输出流
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            List<Integer> reviewedQuestions = new ArrayList<>(); // 存储已经复习过的题目
            int currentDay = 1;
            int index = 0;

            // 遍历所有复习间隔
            for (int i = 0; i < intervals.length; i++) {
                int interval = intervals[i];

                // 复习间隔逻辑：复习当前天之前的复习内容
                List<Integer> todayQuestions = new ArrayList<>();

                // 如果当前天数已经超过间隔天数，则复习前interval天的题目
                if (currentDay - interval - 1 >= 0) {
                    // 添加之前复习过的题目
                    todayQuestions.addAll(reviewedQuestions.subList(0, Math.min(currentDay - interval - 1, reviewedQuestions.size())));
                }

                // 加上新的5道题目
                while (todayQuestions.size() < 5 && index < totalQuestions) {
                    todayQuestions.add(questions.get(index++));
                }

                // 格式化输出：包含之前复习的题目和新题目
                writer.write("Day " + currentDay + ": " + todayQuestions.toString().replaceAll("[\\[\\]]", "") + "\n");

                // 将今天复习的题目加入已复习列表
                reviewedQuestions.addAll(todayQuestions);

                // 增加天数
                currentDay++;
            }

            // 如果还有剩余题目未被复习，每天继续复习
            while (index < totalQuestions) {
                List<Integer> todayQuestions = new ArrayList<>();
                while (todayQuestions.size() < 5 && index < totalQuestions) {
                    todayQuestions.add(questions.get(index++));
                }
                writer.write("Day " + currentDay + ": " + todayQuestions.toString().replaceAll("[\\[\\]]", "") + "\n");
                currentDay++;
            }

            System.out.println("Review plan has been written to " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the review plan.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 设定开始题目编号和结束题目编号
        int start = 1;
        int end = 100;
        String filePath = "review_plan_with_intervals.txt"; // 输出文件路径
        int[] intervals = {1, 3, 7, 15, 30, 45, 67}; // 复习间隔天数

        // 生成复习计划
        generateReviewPlan(start, end, intervals, filePath);
    }
}


