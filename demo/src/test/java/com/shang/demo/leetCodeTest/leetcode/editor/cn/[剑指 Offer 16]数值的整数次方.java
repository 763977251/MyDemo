package com.shang.demo.leetCodeTest.leetcode.editor.cn;
//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ）。不得使用库函数，同时不需要考虑大数问题。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2⁻² = 1/2² = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 数学 👍 297 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution剑指Offer16 {
    public double myPow(double x, int n) {
        //将正数n和负数n都给转换为正数n
        // 注意：Java 代码中 int32 变量n∈[−2147483648,2147483647]
        // 因此当 n = -2147483648 时执行 n = -n 会因越界而赋值出错
        // 我们此处一开始就把 n 用 long 存储
        long b = n;
        if (n<0){
            b = -b;
            x = 1/x;
        }
        return culc(x,b);
    }

    //快速幂模版
    // 递归的进行x的n次方计算
    public double culc(double base, long power){
        double res = 1.0;
        while (power >0){
            //两种情况会进入if语句：
            // 1.幂次若为奇数，提前多乘一次x
            // 2.当幂次除到1，把base赋值给res
            if ((power & 1) == 1){
                res *= base;
            }
            power = power >> 1;
            base = base * base;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
