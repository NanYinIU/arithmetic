
package com.leetcode.v2.No160_intersection_of_two_linked_list;

import com.leetcode.ListNode;

/**
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 重要的是怎么处理两个链表长度不一致的情况 使用的方案就是 HeadA的长度是A HeadB的长度是B A+B的长度是一定的 所以让 p1
 * 走完A，再走B，让P2走完B，再走A，最后两个走到相同的节点就是相交的点
 *
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
