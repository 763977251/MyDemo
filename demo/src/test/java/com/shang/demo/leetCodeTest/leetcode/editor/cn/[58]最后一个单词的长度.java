package com.shang.demo.leetCodeTest.leetcode.editor.cn;//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
//解释：最后一个单词是“World”，长度为5。
// 
//
// 示例 2： 
//
// 
//输入：s = "   fly me   to   the moon  "
//输出：4
//解释：最后一个单词是“moon”，长度为4。
// 
//
// 示例 3： 
//
// 
//输入：s = "luffy is still joyboy"
//输出：6
//解释：最后一个单词是长度为6的“joyboy”。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅有英文字母和空格 ' ' 组成 
// s 中至少存在一个单词 
// 
//
// Related Topics 字符串 👍 487 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_58 {

    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end>=0 && s.charAt(end) == ' '){
            end--;
        }
        if (end < 0){
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' '){
            start--;
        }
        return end-start;
    }

//    public int lengthOfLastWord(String s) {
//        if (s == null){
//            return 0;
//        }
//        s = s.trim();
//        if (s.length() == 0){
//            return 0;
//        }
//        String[] s1 = s.split(" ");
//        return s1[s1.length-1].length();
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
