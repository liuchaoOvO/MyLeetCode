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
        //坑位是3个
        LRUCacheDemo lruCacheDemo=new LRUCacheDemo<>(3);
        lruCacheDemo.put(1,"a");
        lruCacheDemo.put(2,"b");
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(4,"d");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(5,"x");
        System.out.println(lruCacheDemo.keySet());
    }
}
