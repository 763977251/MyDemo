package com.shang.demo.leetCodeTest.leetcode.editor.cn;//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 824 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution剑指Offer51 {
    int[] nums, tmp;
    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0,nums.length-1);
    }

    private int mergeSort(int l, int r) {
        if (l>=r) return 0;
        int m = (l+r)/2;
        int res = mergeSort(l,m) + mergeSort(m+1,r);
        int i = l, j =m+1;
        for (int k = l; k <= r; k++) {
            tmp[k] = nums[k];
        }
        for (int k = l; k <=r ; k++) {
            if (i == m+1){
                nums[k] = tmp[j++];
            } else if (j == r+1 || tmp[i] <= tmp[j]){
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
                res += m-i+1;
            }
        }
        return res;
    }

//    public int reversePairs(int[] nums) {
//        int res = 0;
//        for (int i = 0; i < nums.length-1; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] > nums[j]){
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
