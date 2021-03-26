package com.lc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuchao02
 * @ClassName: leetcode15
 * @Description: 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/25 19:29
 * <p>
 * 思路：采取固定一个数，同时用双指针来查找另外两个数的方式
 */
public class leetcode15 {

    public static void main(String[] args) {
        int[] arr = {6, 4, 5, 234, 324543, 12342, 3456, 245, 567, 223, 1221, 9, -1, -2, 3, -3};
        List<List<Integer>> list = threeSum(arr);
        list.forEach(a -> System.out.println("result:" + Arrays.toString(a.toArray())));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        quickSortArr(nums, 0, nums.length - 1);//先对数组进行快速排序
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            if (nums[i] > 0) break;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    ArrayList list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
                if (nums[l] + nums[r] < target) l++;
                if (nums[l] + nums[r] > target) r--;
            }
        }
        return res;
    }

    private static void quickSortArr(int[] nums, int start, int end) {
        if (start < end) {
            int povitIndex = findPovitIndex(nums, start, end);
            quickSortArr(nums, start, povitIndex - 1);
            quickSortArr(nums, povitIndex + 1, end);
        }
    }

    private static int findPovitIndex(int[] nums, int start, int end) {
        int povit = nums[start];
        while (start < end) {
            while (start < end && povit <= nums[end]) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && povit >= nums[start]) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = povit;
        return start;
    }
}
