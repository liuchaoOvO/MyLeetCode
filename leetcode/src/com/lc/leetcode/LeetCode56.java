package com.lc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuchao02
 * @ClassName: LeetCode56
 * @Description: 合并区间
 * 问题描述
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * <p>
 * 思路：
 * 我们用动态数组 ArrayList集合lists来存储最终的答案。
 * 首先，我们将列表中的区间按照左端点升序排序。
 * 随后，扫描整个区间，扫描的过程中我们把所有可能有交集的区间进行合并。
 * 我们每次需要维护一个当前的区间，并在循环前，另待合并区间的第一个区间作为当前区间：
 * 1.如果我们扫描时选中的区间的左端点在当前区间的右端点之后，那么它们不会重合，我们可以将当前区间添加到结果集合中，并更新当前区间为扫描时选中的区间；
 * 2.否则，它们重合，我们需要比较当前区间的右端点值和扫描时选中的区间的右端点值，将当前区间的右端点值置为二者的较大值。
 * @date 2021/2/19 17:44
 */
public class LeetCode56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 4}, {5, 6}};
        int[][] resultArr = mergeArr(intervals);
    }

    private static int[][] mergeArr(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        //对区间左端点进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //创建动态数组用于保存最终结果集
        List<int[]> resultList = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        int lengh = intervals.length;
        for (int i = 0; i < lengh; i++) {
            //当选中的区间左端点大于当前区间的右端点时，两区间没有交集
            if (intervals[i][0] > end) {
                //把当前区间左右端点添加到结果集中
                int[] temp = new int[2];
                temp[0] = start;
                temp[1] = end;
                resultList.add(temp);
                //更新当前区间左右端点
                start = intervals[i][0];
                end = intervals[i][1];
            } else {//当选中的区间左端点小于等于当前区间的右端点时，两区间有交集
                end = Math.max(intervals[i][1], end);
            }
        }
        //最终还需要把当前区间的左右端点添加到结果集中
        int[] temp = new int[2];
        temp[0] = start;
        temp[1] = end;
        resultList.add(temp);
        int[][] res = new int[resultList.size()][2];
        //把动态数组的结果集加入到二维数组结果集中
        for (int i = 0; i < resultList.size(); i++) {
            res[i][0] = resultList.get(i)[0];
            res[i][1] = resultList.get(i)[1];
        }
        return res;
    }
}
