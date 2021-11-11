package com.shang.demo.leetCodeTest;

import java.util.Arrays;

public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] ints = sortedSquares(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        System.out.println("============");
        int[] ints2 = sortedSquares2(nums);
        for (int anInt : ints2) {
            System.out.println(anInt);
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    public static int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0, j = n-1, pos = n-1;
        while (i <= j){
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                i++;
            } else {
                ans[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }
        return ans;
    }
}
