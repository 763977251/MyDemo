package com.shang.demo.leetCodeTest.leetcode.editor.cn;//给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
//
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：n = 2
//输出：[0,1,1]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：[0,1,1,2,1,2]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？ 
// 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ） 
// 
//
// Related Topics 位运算 动态规划 👍 1081 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_338 {

    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    private int countOnes(int x) {
        int ones = 0;
        while (x > 0){
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
