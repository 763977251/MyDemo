package com.shang.demo.leetCodeTest.leetcode.editor.cn;//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 280 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution剑指Offer06 {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head=head.next;
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.empty()){
            Integer pop = stack.pop();
            result[i] = pop;
            i++;
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
