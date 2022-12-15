package com.shang.demo.leetCodeTest.leetcode.editor.cn;//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 
//
// 示例1: 
//
// 
//输入: pattern = "abba", s = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 
//输入:pattern = "abba", s = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 
//输入: pattern = "aaaa", s = "dog cat cat dog"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= pattern.length <= 300 
// pattern 只包含小写英文字母 
// 1 <= s.length <= 3000 
// s 只包含小写英文字母和 ' ' 
// s 不包含 任何前导或尾随对空格 
// s 中每个单词都被 单个空格 分隔 
// 
//
// Related Topics 哈希表 字符串 👍 496 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_290 {
    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] strings = s.split(" ");
        if (chars.length != strings.length){
            return false;
        }
        Map<Character, String> char2string = new HashMap<>();
        Map<String, Character> string2char = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if ((char2string.containsKey(chars[i]) && !strings[i].equals(char2string.get(chars[i])))
            || (string2char.containsKey(strings[i]) && chars[i] != string2char.get(strings[i]))){
                return false;
            }
            char2string.put(chars[i], strings[i]);
            string2char.put(strings[i], chars[i]);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
