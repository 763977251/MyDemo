package com.shang.demo.leetCodeTest.leetcode.editor.cn;//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 👍 2425 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        return str1.substring(0,index);
    }
//
//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0){
//            return "";
//        }
//        int length = strs[0].length();
//        int count = strs.length;
//        for (int i = 0; i < length; i++) {
//            char ch = strs[0].charAt(i);
//            for (int j = 1; j < count; j++) {
//                if (i == strs[j].length() || strs[j].charAt(i) != ch){
//                    return strs[0].substring(0,i);
//                }
//            }
//        }
//        return strs[0];
//    }

//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length < 1) {
//            return "";
//        } else if (strs.length == 1) {
//            return strs[0];
//        }
//        StringBuilder sb = new StringBuilder("");
//        String str = strs[0];
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            boolean isEqu = true;
//            for (int j = 1; j < strs.length; j++) {
//                if (i >= strs[j].length() || ch != strs[j].charAt(i)) {
//                    isEqu = false;
//                }
//            }
//            if (!isEqu) {
//                break;
//            } else {
//                sb.append(ch);
//            }
//        }
//        return sb.toString();
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
