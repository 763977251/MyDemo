package com.shang.demo.leetCodeTest.leetcode.editor.cn;//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
//
// Related Topics 数学 双指针 字符串 👍 290 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution剑指Offer58_2 {
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        n = n % length;
        String s1 = s.substring(0, n);
        String s2 = s.substring(n, length);
        return s2+s1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
