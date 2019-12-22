package com.dataStructures;

/**
 * 判断是否为回文数
 */
public class IsPalindrome {
    public boolean solution(int x){
        if(x < 0){
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String org = Integer.toString(x);
        for (int i = org.length(); i > 0; i--) {
            stringBuilder.append(org.charAt(i-1));
        }
        return stringBuilder.toString().equals(org);
    }

    public boolean solution2(int x){
        if(x < 0){
            return false;
        }
        String org = Integer.toString(x);
        for (int i = 0; i < org.length()/2 + 1; i++) {
           if(org.charAt(i) != org.charAt(org.length()-i-1)) {
               return false;
           }
        }
        return true;
    }

    public boolean solution3(int x){
        if(x < 0|| (x % 10 == 0 && x != 0)){
            return false;
        }
        //1221  revertedNumber 应为21反转后的12
        int revertedNumber = 0;
        while (x > revertedNumber){
            // 第一次 1 第二次应为 1*10 + 2
            revertedNumber=revertedNumber*10 + x%10;
            // 每次x递减
           x/=10;
        }
        return x==revertedNumber || x==revertedNumber/10;

    }


    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.solution3(1212));
        System.out.println(122%10);
    }
}
