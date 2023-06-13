package com.shang.demo.leetCodeTest.leetcode.editor.cn;//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 961 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int lens = s.length();
        int i = 0;
        while (++i < lens) {
            if (lens % i != 0) {
                continue;
            }
            if (s.substring(lens - i, lens).equals(s.substring(0,i))) {
                if (s.substring(i, lens).equals(s.substring(0,lens-i))) {
                    return true;
                }
            }
        }
        return false;
    }
//    public boolean repeatedSubstringPattern(String s) {
//        if (s == null || s.length() == 0) return false;
//        int len = s.length();
//        s = " " + s;
//        char[] chars = s.toCharArray();
//        int[] next = new int[len + 1];
//        for (int i = 2, j = 0; i <= len; i++) {
//            while (j > 0 && chars[i] != chars[j + 1]) {
//                j = next[j];
//            }
//            if (chars[i] == chars[j + 1]) {
//                j++;
//            }
//            next[i] = j;
//        }
//        if (next[len] > 0 && len % (len - next[len]) == 0) {
//            return true;
//        }
//        return false;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
