package com.leetcode.v2.No23_merge_k_sorted_list;

import com.leetcode.ListNode;

/**
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]] 输出：[1,1,2,3,4,4,5,6] 解释：链表数组如下： [ 1->4->5,
 * 1->3->4, 2->6 ] 将它们合并到一个有序链表中得到。 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int middle = left + (right - left) / 2;
        ListNode leftNode = merge(lists, left, middle);
        ListNode rightNode = merge(lists, middle + 1, right);
        return mergeTwoLists(leftNode, rightNode);
    }

    /**
     * 第二种循环,就是正常的while循环，判断两个节点是否都完成合并
     *
     */
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode();
        ListNode p = dump;
        ListNode p1, p2;
        p1 = l1;
        p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dump.next;
    }

    /**
     * 第一种递归。。。
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
