package com.lc.leetcode;

/**
 * @author liuchao02
 * @ClassName: leetcode53
 * @Description: 最大子序和
 * 算法思想
 * 本题可以采用动态规划的方法来实现
 * 问题描述
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @date 2021/2/23 17:45
 */
public class leetcode53 {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = dp(arr);
        System.out.println(result);
    }

    public static int dp(int[] nums) {
        //maxSub[i]表示以i为起点的连续子数组的最大和
        int maxSub[] = new int[nums.length];
//最后一个元素为起点的连续子数组的最大和就等于其自己
        maxSub[nums.length - 1] = nums[nums.length - 1];
//result可以用来保存整个数组的连续子数组的最大和
        int result = maxSub[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            //检查加上后面一个数组的连续子数组的最大和是否会导致变小。
            if (nums[i] + maxSub[i + 1] > nums[i]) {
                maxSub[i] = nums[i] + maxSub[i + 1];
            } else {
                maxSub[i] = nums[i];
            }
            if (maxSub[i] > result) {
                result = maxSub[i];
            }
        }
        return result;
    }

}
