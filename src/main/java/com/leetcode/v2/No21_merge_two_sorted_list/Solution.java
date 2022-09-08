package com.leetcode.v2.No21_merge_two_sorted_list;

import com.leetcode.ListNode;

/**
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 输入：l1 = [1,2,4], l2 =
 * [1,3,4] 输出：[1,1,2,3,4,4] 示例 2：
 *
 * 输入：l1 = [], l2 = [] 输出：[] 示例 3：
 *
 * 输入：l1 = [], l2 = [0] 输出：[0]
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
class Solution {

    // 定义虚拟关节点，用于最后节点的返回
    ListNode dump = new ListNode();
    // 组装数据的移动的指针
    ListNode p = dump;
    // 两个对应List的两个指针，用于在两个List止移动
    ListNode p1, p2;

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        p1 = list1;
        p2 = list2;
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
        // 最后看谁被剩下了。。
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dump.next;
    }
}
