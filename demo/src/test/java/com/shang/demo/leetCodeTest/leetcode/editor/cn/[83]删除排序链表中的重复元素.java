package com.shang.demo.leetCodeTest.leetcode.editor.cn;//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 👍 844 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution_83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null){
            if (curr.val == curr.next.val){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null){
//            return head;
//        }
//        ListNode pre = head;
//        ListNode curr = head.next;
//        while (curr != null){
//            if (pre.val == curr.val){
//                pre.next = curr.next;
//                curr = curr.next;
//                continue;
//            }
//            pre = curr;
//            curr = curr.next;
//        }
//        return head;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
