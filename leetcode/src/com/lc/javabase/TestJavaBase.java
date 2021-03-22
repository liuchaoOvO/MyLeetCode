package com.lc.javabase;

/**
 * @author liuchao02
 * @ClassName: TestJavaBase
 * @Description:
 * @date 2021/2/19 11:16
 */
public class TestJavaBase { //1 6 2 3 7 8       5 1 10 6  3 2 8 7
}
class Father {
    private static int j = method();
    private int i = test();
    static {
        System.out.println(1);
    }
    public Father() {
        System.out.println(2);
    }
    {
        System.out.println(3);
    }
    public int test() {
        System.out.println(4);
        return 1;
    }
    private static int method() {
        System.out.println(5);
        return 1;
    }
}

 class Son extends Father {
    private static int j = method();
    private int i = test();
    static {
        System.out.println(6);
    }
    public Son() {
        System.out.println(7);
    }
    {
        System.out.println(8);
    }
    public int test() {
        System.out.println(9);
        return 1;
    }
    private static int method() {
        System.out.println(10);
        return 1;
    }


    public static void main(String[] args) {
        System.out.println();
        Son son1 = new Son();

    }
}
