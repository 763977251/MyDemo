package com.shang.demo.leetCodeTest.leetcode.editor.cn;//给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4ˣ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不使用循环或者递归来完成本题吗？ 
//
// Related Topics 位运算 递归 数学 👍 319 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_342 {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1))==0 && n % 3 == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
