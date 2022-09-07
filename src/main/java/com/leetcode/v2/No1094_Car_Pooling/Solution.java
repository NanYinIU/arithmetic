package com.leetcode.v2.No1094_Car_Pooling;

/**
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 *
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i
 * 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 *
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 *
 * 示例 1：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4 输出：false 示例 2：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5 输出：true
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/car-pooling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    int[] maxArr;

    public boolean carPooling(int[][] trips, int capacity) {
        maxArr = new int[1000];
        for (int index = 0; index < trips.length; index++) {
            boolean yes = getCar(trips[index], capacity);
            if (!yes) {
                return false;
            }
        }
        return true;
    }

    public boolean getCar(int[] trip, int capacity) {
        int num = trip[0];
        int from = trip[1];
        int to = trip[2];
        for (int i = from; i < to; i++) {
            maxArr[i] = maxArr[i] + num;
            if (maxArr[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
