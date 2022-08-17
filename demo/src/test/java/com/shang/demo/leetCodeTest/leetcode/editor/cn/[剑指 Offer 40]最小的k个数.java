package com.shang.demo.leetCodeTest.leetcode.editor.cn;//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 473 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int[] getLeastNumbers(int[] arr, int k) {
//        int[] array = Arrays.stream(arr).sorted().toArray();
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = array[i];
//        }
//        return res;
//    }
//}
class Solution剑指Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr,0,arr.length-1);
        return Arrays.copyOf(arr,k);
    }
    void quickSort(int[] arr, int l, int r){
        if (l >= r){
            return;
        }
        int i = l, j = r;
        while (i < j){
            while (i < j && arr[j] >= arr[l]){
                j--;
            }
            while (i < j && arr[i] <= arr[l]){
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        quickSort(arr, l, i -1);
        quickSort(arr, i + 1, r);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
