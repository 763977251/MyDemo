package com.shang.demo.leetCodeTest;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        int[] nums2 = new int[]{0,0,1};
        moveZeroes2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println("==========");
        moveZeroes2(nums2);
        for (int num : nums2) {
            System.out.println(num);
        }
    }

    public static void moveZeroes(int[] nums) {
        int right = nums.length;
        for (int i = 0; i < right; i++) {
            int num = nums[i];
            if (num == 0){
                for (int j = i; j < right-1; j++) {
                    nums[j] = nums[j+1];
                }
                nums[right-1] = num;
                right--;
                i--;
            }
        }
    }
    public static void moveZeroes2(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n){
            if (nums[right] != 0){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        while (left < n){
            nums[left] = 0;
            left++;
        }
    }
}
