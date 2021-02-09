package com.lc.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuchao02
 * @ClassName: TestMulThreadNotify
 * @Description: 多线程通讯（循环打印 每个线程的值）
 * 要求：
 * 编写一个程序，开启 3 个线程，这三个线程的 ID 分别为 A、B、C，
 * 每个线程将自己的 ID 在屏幕上打印 10 遍，要求输出的结果必须按顺序显示。
 * 如：ABCABCABC…… 依次递归
 * @date 2021/2/9 17:07
 */
public class TestMulThreadNotify {
    public static void main(String[] args) {
        CommonPart commonPart = new CommonPart();
        new Thread("A") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    commonPart.a();
                }
            }
        }.start();
        new Thread("B") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    commonPart.b();
                }
            }
        }.start();
        new Thread("C") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    commonPart.c();
                }
            }
        }.start();
    }


}

class CommonPart {
    private static volatile int number = 1;//当前正在执行的线程的标记

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void a() {
        lock.lock();
        try {
            if (number != 1) {
                condition1.await();
            }
            System.out.print(Thread.currentThread().getName());
            number = 2;
            condition2.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }


    public void b() {
        lock.lock();
        try {
            if (number != 2) {
                condition2.await();
            }
            System.out.print(Thread.currentThread().getName());
            number = 3;
            condition3.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void c() {
        lock.lock();
        try {
            if (number != 3) {
                condition3.await();
            }
            System.out.print(Thread.currentThread().getName());
            number = 1;
            condition1.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }


}


