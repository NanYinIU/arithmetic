package com.leetcode.v2.No652_find_duplicate_subtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leetcode.TreeNode;

/**
 *
 * 给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
 *
 * 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
 *
 * 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/find-duplicate-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

class Solution {
    // 设置 map 做备忘录存储临时结果
    Map<String, Integer> memo = new HashMap<>();

    List<TreeNode> resList = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return resList;
    }

    public String traverse(TreeNode node) {
        if (node == null) {
            return "NULL";
        }
        StringBuffer sb = new StringBuffer();
        // 将所有过程全部拼成 string 字符串，这里面相当于后序的处理方式
        String key = sb.append(node.val).append("_").append(traverse(node.left)).append("_")
                .append(traverse(node.right)).toString();
        // 看字符串是否在 map 中存在，如果存在，则说明有重复值
        if (memo.containsKey(key)) {
            memo.put(key, memo.get(key) + 1);
        } else {
            memo.put(key, 1);
        }
        if (memo.get(key) == 2) {
            resList.add(node);
        }
        return key;
    }
}
