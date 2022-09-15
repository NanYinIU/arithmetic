package com.leetcode.v2.No019_remove_nth_node_from_end_of_list;

import com.leetcode.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2 输出：[1,2,3,5] 示例 2：
 *
 * 输入：head = [1], n = 1 输出：[] 示例 3：
 *
 * 输入：head = [1,2], n = 1 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;

        dummy.next = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        // 前一个指针 = 下一个指针,修改pre就是修改dummy
        pre.next = slow.next;
        return dummy.next;
    }
}
