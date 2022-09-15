package com.leetcode.v2.No141_linked_list_cycle;

import com.leetcode.ListNode;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos
 * 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1 输出：true 解释：链表中有一个环，其尾部连接到第二个节点。 示例 2：
 *
 * 输入：head = [1,2], pos = 0 输出：true 解释：链表中有一个环，其尾部连接到第一个节点。 示例 3：
 *
 * 输入：head = [1], pos = -1 输出：false 解释：链表中没有环。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 两种思路
     *
     * 1. 第一种是开辟额外空间，存储路径上的元素，如果存在重复，则返回true
     *
     * 2. 第二种是快慢指针，快指针 +2 慢指针+1，如果 快指针 == 慢指针 返回 true, 直到快指针走到尽头
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null) {
            // 如果快指针走到了头
            if (fast == null || fast.next == null) {
                return false;
            }
            // 如果两个指针相遇
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
