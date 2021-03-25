package com.lc.javabase;

import java.util.LinkedHashMap;

/**
 * @author liuchao02
 * @ClassName: LRUCacheDemo
 * @Description:
 * 具体blog 地址：https://blog.csdn.net/qq_39736597/article/details/113791512
 * @date 2021/2/20 17:34
 */
public class LRUCacheDemo<K,V> extends LinkedHashMap<K,V> {
    private int capacity;
    public LRUCacheDemo(int capacity){
        //参数1，坑位，传过来的值，参数2，加载因子，参数3，访问顺序
        super(capacity,0.75F,true);
        this.capacity=capacity;
    }
    //怎么弹出去一个坑位
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return super.size()>capacity;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,3,3,3,3,6,7};
        System.out.println(MoreThanHalfNum_Solution(array));
    }

    private static int  MoreThanHalfNum_Solution(int[] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int length=array.length;
        int half=length/2;
        int count=0;//计数
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array.length ; j++) {
                if(array[i]==array[j]){
                    count++;
                    if(count>half){
                        return array[i];
                    }
                }
            }
            count=0;
        }
        return 0;
    }


}
