package com.shang.demo.leetCodeTest;

public class ReverseWords {

    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < s.length()){
            int start = i;
            while (i < s.length() && s.charAt(i) != ' '){
                i++;
            }
            for (int j = start; j < i; j++) {
                ans.append(s.charAt(i - 1 - (j - start)));
            }
            while (i < s.length() && s.charAt(i) == ' '){
                i++;
                ans.append(' ');
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }
}
