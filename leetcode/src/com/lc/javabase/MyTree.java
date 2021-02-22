package com.lc.javabase;

/**
 * @author liuchao02
 * @ClassName: MyTree
 * @Description: 树 demo
 * @date 2021/2/22 17:02
 */

public class MyTree {
    int data;
    MyTree leftNode;
    MyTree rightNode;

    public MyTree(int data) {
        this.data = data;
        leftNode = null;
        rightNode = null;
    }

    public static void main(String[] args) {

    }

    private void add(MyTree myTree, int data) {
        if (myTree.data > data) {
            if (myTree.leftNode == null) {
                myTree.leftNode = new MyTree(data);
            } else {
                add(myTree.leftNode, data);
            }
        } else {
            if (myTree.rightNode == null) {
                myTree.rightNode = new MyTree(data);
            } else {
                add(myTree.rightNode, data);
            }
        }
    }

    //先序遍历
    public static void first(MyTree myTree) {
        if (myTree != null) {
            System.out.println(myTree.data + " ");
            first(myTree.leftNode);
            first(myTree.rightNode);
        }
    }

    //中序遍历
    public static void mid(MyTree myTree) {
        if (myTree != null) {
            first(myTree.leftNode);
            System.out.println(myTree.data + " ");
            first(myTree.rightNode);
        }
    }

    //中序遍历
    public static void back(MyTree myTree) {
        if (myTree != null) {
            first(myTree.leftNode);
            first(myTree.rightNode);
            System.out.println(myTree.data + " ");
        }
    }

}
