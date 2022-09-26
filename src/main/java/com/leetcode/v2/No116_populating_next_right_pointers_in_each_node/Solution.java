package com.leetcode.v2.No116_populating_next_right_pointers_in_each_node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.leetcode.Node;

/**
 *
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node { int val; Node *left; Node *right; Node *next; } 填充它的每个 next
 * 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 [1,#,2,3,4,5,6,7,#,4,5,6,7,#]
 */
class Solution {

    Queue<Node> stack = new LinkedList<Node>();

    public Node connect(Node root) {
        stack.add(root);
        traverse();
        return root;
    }

    public void traverse() {
        while (!stack.isEmpty()) {
            // stack 的长度就是这一层的宽度，把这一层中的所有节点用next指针相连即可
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                Node node = stack.poll();
                if (node == null) {
                    continue;
                }
                if (i == size - 1) {
                    node.next = null;
                } else {
                    Node nextNode = stack.peek();
                    node.next = nextNode;
                }
                Node left = node.left;
                Node right = node.right;
                // 递归处理下一层
                if (left != null) {
                    stack.offer(left);
                }
                if (right != null) {
                    stack.offer(right);
                }
            }
        }
    }
}
