package com.lc.javabase;

import java.util.Random;
import java.util.Stack;

/**
 * @author liuchao02
 * @ClassName: MyQueue
 * @Description: 两个栈实现一个队列demo
 * 两个栈实现一个队列：
 * 思路：先将数据存到第一个栈里，再将第一个栈里的元素全部出栈到第二个栈，第二个栈出栈，即可达到先进先出
 * @date 2021/2/24 16:32
 */
public class MyQueue<E> {
        //用的jdk自带的栈
        private Stack<E> s1=new Stack<>();
        private Stack<E> s2=new Stack<>();
        public void offer(E val){   //入队
            s1.push(val);
        }
        public E poll() {   //出队
            while (s2.empty()){
                while (!s1.empty()){
                    s2.push(s1.peek());
                    s1.pop();
                }
            }
            E val=s2.peek();
            s2.pop();
            //获取出队元素后，再将s2里面的元素放入s1里面。
            while (!s2.empty()){
                s1.push(s2.pop());
            }
            return val;
        }

        public E peek(){//查看对头元素
            while (s2.empty()){
                while (!s1.empty()){
                    s2.push(s1.peek());
                    s1.pop();
                }
            }
            E val=s2.peek();
            //获取出队元素后，再将s2里面的元素放入s1里面。
            while (!s2.empty()){
                s1.push(s2.pop());
            }
            return val;
        }

        public boolean empty(){ //判断队是否为空
            return s1.empty();
        }

    //测试
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int data = rand.nextInt(100);
            System.out.print(data + " ");
            queue.offer(data);
        }
        System.out.println();
        System.out.println("出队：");
        while (!queue.empty()) {
            System.out.print(queue.poll()+" ");
        }
    }
}
