package com.shang.demo.leetCodeTest.leetcode.editor.cn;//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 487 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution剑指Offer48 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, tmp =0;
        for (int j = 0; j < s.length(); j++) {
            int i = j -1;
            while (i>=0 && s.charAt(i) != s.charAt(j))i--;
            tmp = tmp < j-i ? tmp +1:j-i;
            res = Math.max(res,tmp);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
