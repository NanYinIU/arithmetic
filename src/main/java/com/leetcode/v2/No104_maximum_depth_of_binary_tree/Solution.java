package com.leetcode.v2.No104_maximum_depth_of_binary_tree;

import com.leetcode.TreeNode;

/**
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例： 给定二叉树 [3,9,20,null,null,15,7]，
 *
 * 3 / \ 9 20 / \ 15 7 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
class Solution {

    // public int maxDepth(TreeNode root) {
    // if (root == null) {
    // return 0;
    // }
    // int left = maxDepth(root.left);
    // int right = maxDepth(root.right);
    // return 1 + Math.max(left, right);
    // }
    //

    int result = 0;
    int deep = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return result;
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        deep++;
        traverse(node.left);
        traverse(node.right);
        result = Math.max(deep, result);
        deep--;
    }

}
