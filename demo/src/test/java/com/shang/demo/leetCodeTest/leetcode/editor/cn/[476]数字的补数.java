package com.shang.demo.leetCodeTest.leetcode.editor.cn;//对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
//
// 
// 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。 
// 
//
// 给你一个整数 num ，输出它的补数。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：num = 5
//输出：2
//解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
// 
//
// 示例 2： 
//
// 
//输入：num = 1
//输出：0
//解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num < 2³¹ 
// 
//
// 
//
// 注意：本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相
//同 
//
// Related Topics 位运算 👍 347 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_476 {
    public int findComplement(int num) {
        int hightbit = 0;
        for (int i = 1; i <= 30; i++) {
            if (num >= 1 << i) {
                hightbit = i;
            } else {
                break;
            }
        }
        int mask = (1 << (hightbit + 1)) - 1;
        return num ^ mask;
    }



}
//leetcode submit region end(Prohibit modification and deletion)
