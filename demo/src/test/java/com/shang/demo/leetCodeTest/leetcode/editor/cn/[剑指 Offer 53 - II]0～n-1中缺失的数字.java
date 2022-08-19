package com.shang.demo.leetCodeTest.leetcode.editor.cn;//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
//
// Related Topics 位运算 数组 哈希表 数学 二分查找 👍 304 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution剑指Offer53_2 {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length-1;
        while (i <= j){
            int m = (i + j)/2;
            if (nums[m] == m) i=m+1;
            else j = m-1;
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
