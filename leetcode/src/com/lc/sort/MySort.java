package com.lc.sort;

import java.lang.reflect.Array;

/**
 * @author liuchao02
 * @ClassName: MySort
 * @Description: 常见排序算法
 * @date 2021/2/9 15:24
 */
public class MySort {
    public static void main(String[] args) {
        int[] arr = {6, 4, 5,234,324543,12342,3456,245,567,223,1221,9};
        //冒泡排序
        doBubbleSort(arr);

        //快速排序
        doQuickSort(arr, 0, arr.length - 1);



        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void doBubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void doQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int povitIndex = getPovitIndex(arr, low, high);
            doQuickSort(arr, low, povitIndex - 1);
            doQuickSort(arr, povitIndex + 1, high);
        }
    }


    private static int getPovitIndex(int[] arr, int low, int high) {
        // 基准数据
        int temp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && temp <= arr[high]) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && temp >= arr[low]) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;

    }
}
