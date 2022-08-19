package com.shang.demo.leetCodeTest.leetcode.editor.cn;//统计一个数字在排序数组中出现的次数。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
//
// Related Topics 数组 二分查找 👍 350 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution剑指Offer53_1 {

    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums,target-1);
    }

    private int helper(int[] nums, int tar) {
        int i =0,j=nums.length-1;
        while (i<=j){
            int m = (i+j)/2;
            if (nums[m] <= tar) i=m+1;
            else j = m-1;
        }
        return i;
    }
//    public int search(int[] nums, int target) {
//        int res = 0;
//        for (int num : nums) {
//            if (num<target)continue;
//            if (num == target) res++;
//            if (num>target)break;
//        }
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
