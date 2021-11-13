package com.shang.demo.leetCodeTest;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        // 记录每个字符串是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为-1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i!=0){
                // 表示左指针向右移动一格，此时移除一个字符串
                occ.remove(s.charAt(i-1));
            }
            while (rk + 1 <n && !occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk+1));
                rk++;
            }
            ans = Math.max(ans, rk-i+1);
        }
        return ans;
    }

    @Test
    public void test(){
        String s = "ab";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
