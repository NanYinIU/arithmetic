package com.leetcode.v1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author nanyin
 * @class CombinationSum.java
 * @description
 * @create 13:56 2020-03-30
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {

    private static List<List<Integer>> res =  new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 声明一个结果集
        List<Integer> choose = new LinkedList<>();
        process(0,candidates,target,choose);
        return res;
    }

    private void process(int start, int[] candidates, int target, List<Integer> list){
        if(target < 0){
            // 溢出，也就是说选择的路径不能满足条件
            return;
        }
        if(target == 0){
            // 满足条件，添加到最终的结果中
            res.add(new ArrayList<>(list));
        }else{
            //其他情况下,在剩余数组中作出选择
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                //因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
                process(i, candidates, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] ints = new int[]{2, 3, 5};
        List<List<Integer>> lists = combinationSum.combinationSum(ints, 8);
        for (List<Integer> list : res) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

}
