package com.shang.demo.leetCodeTest.leetcode.editor.cn;//你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
//
// 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 5
//输出：2
//解释：因为第三行不完整，所以返回 2 。
// 
//
// 示例 2： 
// 
// 
//输入：n = 8
//输出：3
//解释：因为第四行不完整，所以返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 262 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_441 {
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

//    public int arrangeCoins(int n) {
//        int ans = 0;
//        if (n <= 0) {
//            return ans;
//        }
//        while (n >= ans + 1) {
//            ans++;
//            n = n - ans;
//        }
//        return ans;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
