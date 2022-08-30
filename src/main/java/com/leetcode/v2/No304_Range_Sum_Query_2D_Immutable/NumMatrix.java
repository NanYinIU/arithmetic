package com.leetcode.v2.No304_Range_Sum_Query_2D_Immutable;

/**
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。 实现 NumMatrix 类：
 *
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化 int sumRegion(int row1, int
 * col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和
 * 。  
 *
 * 示例 1： ![实例1](https://pic.leetcode-cn.com/1626332422-wUpUHT-image.png)
 *
 * 输入: ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 * 输出: [null, 8, 11, 12]
 *
 * 解释: NumMatrix numMatrix = new
 * NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author nanyin
 * @version 1.0
 * @date 2022-08-30
 */

public class NumMatrix {
    private int[][] preNumMatrix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return;
        }
        preNumMatrix = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 注意这里的 matrix 为 i 和 j ，不是 i+1,j+1 是因为 preNum 比 matrix 横轴纵轴都多了1, 后面的 sumRangion
                // 取结果也是一样的
                preNumMatrix[i + 1][j + 1] = preNumMatrix[i][j + 1] + preNumMatrix[i + 1][j] - preNumMatrix[i][j]
                        + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preNumMatrix[row2 + 1][col2 + 1] - preNumMatrix[row2 + 1][col1] - preNumMatrix[row1][col2 + 1]
                + preNumMatrix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj
 * = new NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
