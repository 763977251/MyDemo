package com.shang.demo.leetCodeTest;

/**
 * 搜索插入位置
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 0;
        int searchInsert = searchInsert(nums, target);
        System.out.println(searchInsert);
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length-1;
        int ans = length;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
