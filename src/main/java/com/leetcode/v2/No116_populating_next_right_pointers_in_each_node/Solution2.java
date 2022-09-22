
package com.leetcode.v2.No116_populating_next_right_pointers_in_each_node;

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
class Solution2 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        connect(root.left, root.right);
        return root;
    }

    // 我们只要实现一个 traverse 函数来遍历这棵三叉树，
    // 每个「三叉树节点」需要做的事就是把自己内部的两个二叉树节点穿起来
    public void connect(Node left, Node right) {
        if (left != null) {
            left.next = right;
            connect(left.left, left.right);
        }
        if (right != null) {
            connect(right.left, right.right);
        }
        if (left != null && right != null) {
            connect(left.right, right.left);
        }

    }
}
