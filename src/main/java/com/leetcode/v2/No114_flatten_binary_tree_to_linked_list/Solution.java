package com.leetcode.v2.No114_flatten_binary_tree_to_linked_list;

import com.leetcode.TreeNode;

/**
 *
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 展开后的单链表应该与二叉树
 * 先序遍历 顺序相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode right = root.right;
        TreeNode left = root.left;
        flatten(left);
        flatten(right);

        // root的右节点=原来的人左节点
        root.right = left;
        // 左节点设为空
        root.left = null;

        TreeNode p = root;
        // 找到对下面右节点，最后把之前的右节点拼到之前的最左节点上
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
