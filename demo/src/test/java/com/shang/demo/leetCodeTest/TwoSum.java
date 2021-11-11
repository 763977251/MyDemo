package com.shang.demo.leetCodeTest;

public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target){
                    ans[0] = i+1;
                    ans[1] = j+1;
                    return ans;
                }
            }
        }
        return ans;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int t = target - numbers[i];
            int left = i+1;
            int right = numbers.length-1;
            while (left <= right){
                int midIndex = left + (right - left) / 2;
                int midNum = numbers[midIndex];
                if (midNum == t){
                    ans[0] = i + 1;
                    ans[1] = midIndex + 1;
                    return ans;
                } else if (midNum < t){
                    left = midIndex + 1;
                } else {
                    right = midIndex - 1;
                }
            }
        }
        return ans;
    }

    public static int[] twoSum3(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0,right = numbers.length-1;
        while (left < right){
            int sum = numbers[left] + numbers[right];
            if (sum == target){
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            } else if (sum > target){
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] ints = twoSum3(nums, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
