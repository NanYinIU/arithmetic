package com.leetcode.v1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyAtoi {
    public int myAtoi(String str) {
        // 清除前后两端空格
        str = str.trim();
        if("".equals(str)){
            return 0;
        }
        int limit = Integer.MAX_VALUE;
        int negative = 1;
        // 寻找数字
        char firstChar = str.charAt(0);
        StringBuilder stringBuilder = new StringBuilder();
        if (firstChar == '-') {
            negative = -1;
            limit = Integer.MIN_VALUE;
        } else if(firstChar == '+'){
            negative = 1;
        }else {
            int digit = Character.digit(firstChar, 10);
            if (digit == -1) {
                return 0;
            }
            stringBuilder.append(firstChar);
        }


        char[] chars = str.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int digit = Character.digit(chars[i], 10);
            if(digit != -1){
                stringBuilder.append(digit);
            }else{
                break;
            }
        }

//        String num = ;
//        double result = 0;
//        for (int i = 0; i < num.length(); i++) {
//            int digit = Character.digit(num.charAt(i), 10);
//            result = result + digit * Math.pow(10,num.length()-i-1);
//        }
        str = stringBuilder.toString();
        if("".equals(str)){
            return 0;
        }
        double result = Double.parseDouble(str);
        System.out.println(result);
        if((negative == 1 && result >= limit) || (negative == -1 && -1*result <= limit)){
            return limit;
        }
        return negative*Integer.parseInt(str);
    }

    public int myAtoi2(String str){
        str = str.trim();
        if("".equals(str)){
            return 0;
        }
        String reg = "^[+-]?\\d+";
        Pattern patten = Pattern.compile(reg);//编译正则表达式
        Matcher matcher = patten.matcher(str);
        String matchString = "";
        while(matcher.find()){
            matchString = matcher.group();
        }
        if("".equals(matchString)){
            return 0;
        }
        double result = Double.parseDouble(matchString);
        System.out.println(result);
        if(result >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if( result <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi2("   -912 helx"));
    }
}
