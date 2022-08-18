package com.shang.demo.leetCodeTest.leetcode.editor.cn;//给你一个整数数组 nums，请你将该数组升序排列。
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 650 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution912 {
    // 快速排序
    public int[] sortArray(int[] nums) {
        if (nums.length <=1){
            return nums;
        }
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r){
            return;
        }
        int i = l;
        int j = r;
        while (i < j){
            while (i<j && nums[j] >= nums[l]) j--;
            while (i<j && nums[i] <= nums[l]) i++;
            swap(nums,i,j);
        }
        swap(nums,i,l);
        quickSort(nums,l,i);
        quickSort(nums,i+1,j);
    }

    // 归并排序
//    public int[] sortArray(int[] nums) {
//        if (nums.length <=1){
//            return nums;
//        }
//        merge_sort_c(nums,0,nums.length-1);
//        return nums;
//    }

    private void merge_sort_c(int[] nums, int l, int r) {
        if (l >= r){
            return;
        }
        int point = (l + r) /2;
        merge_sort_c(nums, l,point);
        merge_sort_c(nums,point+1,r);
        merge_arr(nums,l,point,r);
    }

    private void merge_arr(int[] nums, int l, int point, int r) {
        int i = l;
        int j = point + 1;
        int k = 0;
        int[] arr = new int[r-i+1];
        while (i <= point && j <= r){
            if (nums[i] <= nums[j]){
                arr[k] = nums[i];
                i++;
            } else {
                arr[k] = nums[j];
                j++;
            }
            k++;
        }

        if (i==point+1){
            while (j<=r){
                arr[k] = nums[j];
                k++;
                j++;
            }
        } else {
            while (i<=point){
                arr[k] = nums[i];
                k++;
                i++;
            }
        }
        System.arraycopy(arr,0,nums,l,arr.length);
    }

    // 选择排序
//    public int[] sortArray(int[] nums) {
//        if (nums.length <=1){
//            return nums;
//        }
//        for (int i = 0; i < nums.length-1; i++) {
//            int tmp = nums[i];
//            int minIndex = i;
//            for (int j = i+1; j < nums.length; j++) {
//                if (tmp > nums[j]){
//                    tmp = nums[j];
//                    minIndex = j;
//                }
//            }
//            if (minIndex != i){
//                swap(nums,minIndex,i);
//            }
//        }
//        return nums;
//    }

    // 插入排序
//    public int[] sortArray(int[] nums) {
//        if (nums.length <= 1){
//            return nums;
//        }
//        for (int i = 1; i < nums.length; i++) {
//            int value = nums[i];
//            int j = i-1;
//            while (j >= 0){
//                if (nums[j] > value){
//                    nums[j+1] = nums[j];
//                } else {
//                    break;
//                }
//                j--;
//            }
//            nums[j+1] = value;
//        }
//        return nums;
//    }

    // 冒泡排序
//    public int[] sortArray(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length - i - 1; j++) {
//                if (nums[j] > nums[j+1]){
//                    swap(nums,j,j+1);
//                }
//            }
//        }
//        return nums;
//    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
