package com.leetcode.v2.No144_binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.TreeNode;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return result;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        int val = node.val;
        result.add(val);
        traverse(node.left);
        traverse(node.right);
    }
}
