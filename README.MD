# 基本排序算法

day01：冒泡排序，解释和程序再 com.nanyin.bubbleSort 包下的 Bubble 类中

day02: 选择插入排序在 com.basic.selectionSort 包下的 selection 类中

day03： 直接插入排序 com.basic.straightInsertSrot 包下的 straightInsert 类

day04: 快速排序 com.basic.quickSort 包下

day05: 希尔排序 com.basic.shellSort 包下

# LeetCode

## 数组

### 前缀和

前缀和技巧适用于 *快速、频繁地计算⼀个索引区间内的元素之和* 。前缀和的核心内容就是新建一个数组，数组内的元素 preNum[i] 为原数组 [0...i] 的和；

```java
class PrefixSum {
    // 前缀和数组
    private int[] prefix;
    /* 输入一个数组，构造前缀和 */
    public PrefixSum(int[] nums) {
        prefix = new int[nums.length + 1];
        // 计算 nums 的累加和
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
    }
    /* 查询闭区间 [i, j] 的累加和 */
    public int query(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }
}
```

#### 一维数组中的前缀和

[一维数组中的前缀和](src/main/java/com/leetcode/v2/No303_Range_Sum_Query_Immutable/NumArray.java)

这个技巧在生活中运用也挺广泛的，比方说，你们班上有若干同学，每个同学有⼀个期末考试的成绩（满 100 分），那么请你实现⼀个 API，输⼊任意⼀个分数段，返回有多少同学的成绩在这个分数段内。

#### 二维数组中的前缀和

[二维数组中的前缀和](src/main/java/com/leetcode/v2/No304_Range_Sum_Query_2D_Immutable/NumMatrix.java)

#### 差分数组

差分数组和前缀和比较类似，不一样的是，差分数组适合频繁对原始数组的某个区间的元素进行增减。

构造类似前缀和的 prefix 数组，对原始 nums 数组构造一个 diff 数组，diff 数组的内容就是 nums 数组前后元素的差值， `diff[i] = nums[i] - nums[i-1];`

现在我们把差分数组抽象成⼀个类，包含 increment 方法和 result 方法：

``` java
class Difference{
    private int[] diff;

    // 构造函数，构造 diff 数组
    public Difference(int[] nums){
        if(nums.length <=0){
            return;
        }
        diff = new int[nums.length+1];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
           diff[i] = nums[i] - nums[i-1];
        }
    }

    // 修改 diff 数组
    public void increment(int start,int end,int incr){
        // 更新 diff 数组， diff[start...end] + incr diff[end...] - incr
        for (int i = start; i <  end; i++) {
            diff[i] += incr;
        }
        for (int j = end; j < diff.length; j++) {
            diff[j] -= incr;
        }
    }

    // 根据 diff 和原始的 nums 数组，计算结果
    public int[] result(){
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = diff[i] + res[i-1];
        }
        return res;
    }

}
```

[1109. Corporate Flight Bookings](src/main/java/com/leetcode/v2/No1109_Corporate_Flight_Bookings/Solution.java)

还有一个很类似的题

[1094. Car Pooling](src/main/java/com/leetcode/v2/No1094_Car_Pooling/Solution.java)

#### 指针类的

- 删除数组中的重复项
[26. Remove Duplicates from Sorted Array](src/main/java/com/leetcode/v2/No026_remove_duplicate_from_sorted_array/Solution.java)

- 移除元素
[27. Remove Element](src/main/java/com/leetcode/v2/No027_remove_element/Solution.java)

- 两数之和
- 反转数组
- 最长回访子串
