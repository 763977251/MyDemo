package com.shang.demo.leetCodeTest;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int search = search(nums, target);
        System.out.println(search);
        int binarySearch = binarySearch(nums, target);
        System.out.println(binarySearch);
    }

    /**
     * 循环查找
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        int length = nums.length;
        if (length ==0){
            return -1;
        }
        int left = 0;
        int right = length-1;
        while (left <= right){
            int midIndex = (right - left) / 2 + left;
            int midNum = nums[midIndex];
            if (midNum == target){
                return midIndex;
            } else if (midNum > target){
                right = midIndex-1;
            } else {
                left = midIndex+1;
            }
        }
        return -1;
    }
}
