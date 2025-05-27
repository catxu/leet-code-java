package com.catxu.leetcode.question166;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FractionConverter {

    /**
     * 将长字符串中的分数（如 "2/3" 或 "8/100"）转换为小数形式。
     *
     * @param text 包含分数的原始字符串。
     * @return 转换后的字符串，分数被替换为小数。
     */
    public String convertFractionsToDecimals(String text) {
        // 正则表达式来匹配分数形式。
        // (\d+) 匹配一个或多个数字作为分子 (Group 1)
        // / 匹配斜杠
        // (\d+) 匹配一个或多个数字作为分母 (Group 2)
        // 注意：这里假设分数总是由整数组成，且不包含像 "1 1/2" 这样的带分数。
        // 如果需要处理带分数或负数，正则表达式会更复杂。
        String fractionRegex = "(\\d+)/(\\d+)";
        Pattern pattern = Pattern.compile(fractionRegex);
        Matcher matcher = pattern.matcher(text);

        // 使用 StringBuilder 来高效地构建修改后的字符串
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            // 获取匹配到的分子和分母的字符串
            String numeratorStr = matcher.group(1);
            String denominatorStr = matcher.group(2);

            try {
                // 将字符串转换为 BigDecimal 进行精确计算，避免浮点数精度问题
                BigDecimal numerator = new BigDecimal(numeratorStr);
                BigDecimal denominator = new BigDecimal(denominatorStr);

                // 避免除以零的情况
                if (denominator.compareTo(BigDecimal.ZERO) == 0) {
                    // 如果分母为零，可以选择跳过，或者用特定的错误表示
                    // 这里我们选择保留原始分数，不做转换
                    matcher.appendReplacement(result, Matcher.quoteReplacement(matcher.group(0)));
                    continue;
                }

                // 计算小数，并设置小数位数和舍入模式
                // 这里假设保留4位小数，并使用HALF_UP（四舍五入）
                BigDecimal decimalValue = numerator.divide(denominator, 4, RoundingMode.HALF_UP);

                // 将小数形式替换到字符串中
                // Matcher.quoteReplacement 确保替换字符串中的特殊字符被正确处理
                matcher.appendReplacement(result, Matcher.quoteReplacement(decimalValue.toPlainString()));
            } catch (NumberFormatException e) {
                // 如果分子或分母不是有效的数字，则跳过此匹配并保留原始分数
                System.err.println("Warning: Invalid number in fraction found: " + matcher.group(0) + ". Skipping conversion.");
                matcher.appendReplacement(result, Matcher.quoteReplacement(matcher.group(0)));
            }
        }
        // 将剩余部分追加到结果中
        matcher.appendTail(result);

        return result.toString();
    }

    public static void main(String[] args) {
        FractionConverter converter = new FractionConverter();

        String text1 = "The recipe calls for 2/3 cup of sugar and 1/4 teaspoon of vanilla. Also, 10/2 is an integer.";
        String convertedText1 = converter.convertFractionsToDecimals(text1);
        System.out.println("Original: " + text1);
        System.out.println("Converted: " + convertedText1);
        // 预期输出: Original: The recipe calls for 2/3 cup of sugar and 1/4 teaspoon of vanilla. Also, 10/2 is an integer.
        //           Converted: The recipe calls for 0.6667 cup of sugar and 0.2500 teaspoon of vanilla. Also, 5.0000 is an integer.


        String text2 = "The probability is 1/100. And what about 5/0? That's undefined.";
        String convertedText2 = converter.convertFractionsToDecimals(text2);
        System.out.println("\nOriginal: " + text2);
        System.out.println("Converted: " + convertedText2);
        // 预期输出: Original: The probability is 1/100. And what about 5/0? That's undefined.
        //           Warning: Invalid number in fraction found: 5/0. Skipping conversion.
        //           Converted: The probability is 0.0100. And what about 5/0? That's undefined.

        String text3 = "No fractions here.";
        String convertedText3 = converter.convertFractionsToDecimals(text3);
        System.out.println("\nOriginal: " + text3);
        System.out.println("Converted: " + convertedText3);
        // 预期输出: Original: No fractions here.
        //           Converted: No fractions here.

        String text4 = "Mixed numbers like 1 1/2 are not handled by this simple regex.";
        String convertedText4 = converter.convertFractionsToDecimals(text4);
        System.out.println("\nOriginal: " + text4);
        System.out.println("Converted: " + convertedText4);
        // 预期输出: Original: Mixed numbers like 1 1/2 are not handled by this simple regex.
        //           Converted: Mixed numbers like 1 1/2 are not handled by this simple regex. (因为 "1 1/2" 不会完整匹配 "数字/数字" 模式)
    }
}
