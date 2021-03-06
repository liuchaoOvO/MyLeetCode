package com.lc.leetcode;

import java.util.Arrays;

/**
 * @author liuchao02
 * @ClassName: leetcode16
 * @Description: 16. 最接近的三数之和
 * 标签：排序和双指针
 * 本题目因为要计算三个数，如果靠暴力枚举的话时间复杂度会到 O(n^3)O(n
 * 3
 * )，需要降低时间复杂度
 * 首先进行数组排序，时间复杂度 O(nlogn)O(nlogn)
 * 在数组 nums 中，进行遍历，每遍历一个值利用其下标i，形成一个固定值 nums[i]
 * 再使用前指针指向 start = i + 1 处，后指针指向 end = nums.length - 1 处，也就是结尾处
 * 根据 sum = nums[i] + nums[start] + nums[end] 的结果，判断 sum 与目标 target 的距离，如果更近则更新结果 ans
 * 同时判断 sum 与 target 的大小关系，因为数组有序，如果 sum > target 则 end--，如果 sum < target 则 start++，如果 sum == target 则说明距离为 0 直接返回结果
 * 整个遍历过程，固定值为 n 次，双指针为 n 次，时间复杂度为 O(n^2)O(n
 * 2
 * )
 * 总时间复杂度：O(nlogn) + O(n^2) = O(n^2)O(nlogn)+O(n
 * 2
 *  )=O(n
 * 2
 *  )
 * <p>
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/3sum-closest/solution/hua-jie-suan-fa-16-zui-jie-jin-de-san-shu-zhi-he-b/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date 2021/3/26 11:47
 */
public class leetcode16 {
    public int threeSumClosest(int[] nums, int target) {
        //对nums数组进行排序
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            int sum = nums[i] + nums[start] + nums[end];
            if (Math.abs(target - ans) < Math.abs(target - sum)) {
                ans = sum;
            }
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else return ans;
        }
        return ans;
    }
}
