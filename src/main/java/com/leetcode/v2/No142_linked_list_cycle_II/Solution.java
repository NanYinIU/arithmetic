package com.leetcode.v2.No142_linked_list_cycle_II;

import com.leetcode.ListNode;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos
 * 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos
 * 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1 输出：返回索引为 1 的链表节点 解释：链表中有一个环，其尾部连接到第二个节点。 示例 2：
 *
 * 输入：head = [1,2], pos = 0 输出：返回索引为 0 的链表节点 解释：链表中有一个环，其尾部连接到第一个节点。 示例 3：
 *
 * 输入：head = [1], pos = -1 输出：返回 null 解释：链表中没有环。  
 *
 * 提示：
 *
 * 链表中节点的数目范围在范围 [0, 104] 内 -105 <= Node.val <= 105 pos 的值为 -1 或者链表中的一个有效索引
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 先让两个节点第一次相遇，此时的节点状态是
        // 1. 可能不在环起点,链表总长度就是 a + b a 是指从起点到环起点长度，b表示循环长度
        // 2. fast = slow + n * b
        // 3. fast = 2 * slow
        // 得出结论是 slow = n * b, 说明慢指针也走了N圈了
        // 而环的交点在 a + nb 处，如果得到这个交点？
        // 让 slow = 0,fast = nb 两个一起走，slow 走 a 步到了 a点，而 fast 走了 a 步，到了 a+ n*b
        // 点，两个相等则当前点就是循环的交点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
