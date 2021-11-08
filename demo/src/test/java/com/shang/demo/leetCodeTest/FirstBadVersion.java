package com.shang.demo.leetCodeTest;

/**
 * 第一个错误的版本
 */
public class FirstBadVersion {
    static int bad = 0;
    public static void main(String[] args) {
        int n = 1;
        bad = 1;
        int firstBadVersion = firstBadVersion(n);
        System.out.println(firstBadVersion);
    }

    public static int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

    public static boolean isBadVersion(int i){
        return bad == i ? true : false;
    }
}
