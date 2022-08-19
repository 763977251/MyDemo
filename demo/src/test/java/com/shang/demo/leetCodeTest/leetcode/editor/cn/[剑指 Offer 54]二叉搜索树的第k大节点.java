package com.shang.demo.leetCodeTest.leetcode.editor.cn;//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 331 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution剑指Offer54 {
    int k;
    int res;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        cuclr(root);
        return res;
    }

    private void cuclr(TreeNode root) {
        if (root == null || k < 0){
            return;
        }
        if (root.right != null) cuclr(root.right);
        if (--k == 0){
            res = root.val;
            return;
        }
        if (root.left !=null) cuclr(root.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
