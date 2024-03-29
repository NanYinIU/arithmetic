package com.leetcode.v2.No303_Range_Sum_Query_Immutable;

/**
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 *
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right 实现
 * NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象 int sumRange(int i, int j) 返回数组
 * nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] +
 * nums[left + 1] + ... + nums[right] )  
 *
 * 示例 1：
 *
 * 输入： ["NumArray", "sumRange", "sumRange", "sumRange"] [[[-2, 0, 3, -5, 2,
 * -1]], [0, 2], [2, 5], [0, 5]] 输出： [null, 1, -1, -3]
 *
 * 解释： NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3) numArray.sumRange(2, 5);
 * // return -1 (3 + (-5) + 2 + (-1)) numArray.sumRange(0, 5); // return -3
 * ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author nanyin
 * @version 1.0
 * @date 2022-08-29
 */
public class NumArray {

    private int[] sumArray;

    public NumArray(int[] nums) {
        int length2 = nums.length;
        sumArray = new int[length2 + 1];
        sumArray[0] = nums[0];
        for (int i = 1; i < length2; i++) {
            sumArray[i] = sumArray[i - 1] + nums[i];
        }
    }

    /**
     * 这是一个备注
     */
    public int sumRange(int left, int right) {
        if (left == 0) {
            return sumArray[right];
        }
        return sumArray[right] - sumArray[left - 1];
    }
}
