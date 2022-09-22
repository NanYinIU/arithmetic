package com.leetcode.v2.No226_invert_binary_tree;

import com.leetcode.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 就是左右节点的翻转
 *
 * https://leetcode.cn/problems/invert-binary-tree/
 *
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(left);
        invertTree(right);
        return root;
    }
}
