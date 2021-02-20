package com.lc.leetcode;

/**
 * @author liuchao02
 * @ClassName: Leetcode4
 * @Description: leetcode题解4-寻找两个正序数组的中位数
 * 问题描述
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * <p>
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 算法思想
 * 给出两个有序的数组，要求其中的中位数，显然，当把两个数组合并成一个有序的数组之后，再求中位数就变得非常简单了，
 * 因此，我们需要将这两个有序的数组归并成一个有序的数组，而归并算法的时间复杂度恰好为O(n)
 * 归并算法描述：需要创建一个新的数组，用来保存归并后的有序数组，我们需要使用两个指针变量i,j,分别指向两个有序数组的头部，然后让i,j所指向的元素进行比较，将小的元素放到我们的新数组中，依次这样做，直到所有的元素都放入到新数组中。
 * @date 2021/2/19 12:42
 */
public class Leetcode4 {


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {3, 4};
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] resultArr = new int[len1 + len2]; //创建一个新的数组
        //将两个数组归并起来成为一个更长的数组
        int i = 0;
        int j = 0;
        int k = 0; //i,j,k指针分别指向三个数组的首端
        while ((i < len1) && (j < len2)) {
            //当数组nums1中的元素更小，就将其放入到新数组中，指针后移一位
            while ((i < len1) && (j < len2) && nums1[i] < nums2[j]) {
                resultArr[k++] = nums1[i++];
            }
            //当数组nums2中的元素更小，就将其放入到新数组中，指针后移一位
            while ((i < len1) && (j < len2) && nums1[i] >= nums2[j]) {
                resultArr[k++] = nums2[j++];
            }
        }
        //经过上一轮循环中，可能其中有一个数组中的元素还未全部放入到新数组中
        while (i < len1) {
            resultArr[k++] = nums1[i++];
        }
        while (j < len2) {
            resultArr[k++] = nums2[j++];
        }
        float result = 0;//存储结果
        if ((len1 + len2) % 2 == 0) {
            result = (float) (resultArr[(len1 + len2) / 2 - 1] + resultArr[(len1 + len2) / 2]) / 2;
            System.out.println("result:" + result);
        } else {
            result = resultArr[(len1 + len2) / 2];
            System.out.println("result:" + result);
        }

    }

    /**
     * @param l1
     * @param l2
     * @Description: 合并链表demo method
     * @Date: 17:47
     * @Return: ListNode
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);         //定义头结点
        ListNode p = l1;
        ListNode q = l2;                  //定义双指针
        ListNode r = head;                //定义新的链表的指针
        while (p != null && q != null) {      //当其中一个链表遍历完了，退出循环
            if (p.val < q.val) {            //双指针选择最小的元素添加到新链表中
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            System.out.println(r.val);
            r = r.next;
        }
        while (p != null) {                    //当还有一个链表没有遍历完时，直接连接即可。
            r.next = p;
        }
        while (q != null) {
            r.next = q;
        }
        return head.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }


    }

}
