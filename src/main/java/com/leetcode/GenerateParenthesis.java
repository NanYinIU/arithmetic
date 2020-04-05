package com.leetcode;


import java.util.LinkedList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {
//    public List<String> generateParenthesis(int n) {
//        List<String> list = new LinkedList<>();
//        if(n == 0){
//            list.add("");
//            return list;
//        }else{
//            list = generate(list,"",0,0,n);
//        }
//        return list;
//    }
//
//    private List<String> generate(List<String> list,String s,int left ,int right ,int n) {
//        if(s.length() >= 2*n){
//            list.add(s);
//        }else{
//            // 添加左括号
//            if(left < n){
//                generate(list,s+"(",left+1,right,n);
//            }
//            // 匹配左括号
//            if(right < left){
//                generate(list,s+")",left,right+1,n);
//            }
//        }
//        return list;
//    }

    public List<String> generateParenthesis(int n) {
        // 动态规划
        // 在添加括号内容时，只会添加在括号的中间和外面，也就是 -> （ a ）b
        // 这里的a和b 为 前面算出的结果 但是需要满足条件 a + b + 1 = n；
        // 可以理解为 a个() + b个() + () = n个();
        List<String> list = new LinkedList<>();
        if(n ==0 ){
            list.add("");
            return list;
        }
        for (int i = 0; i < n; i++) {
            for (String a1 : generateParenthesis(i)) {
                for (String a2 : generateParenthesis(n - 1 - i)) {
                    list.add("("+a1+")"+a2);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(2);
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
