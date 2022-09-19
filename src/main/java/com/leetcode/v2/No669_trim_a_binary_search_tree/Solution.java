package com.leetcode.v2.No669_trim_a_binary_search_tree;

import com.leetcode.TreeNode;

/**
 *
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树， 使得所有节点的值在[low, high]中。修剪树
 * 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/trim-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        int val = root.val;
        if (val < low) {
            root = root.right;
            return trimBST(root, low, high);
        }
        if (val > high) {
            root = root.left;
            return trimBST(root, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
};
