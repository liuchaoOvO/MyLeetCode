package com.lc.javabase;

public class ClassLoadTest {
    public static void main(String[] args) {
        System.err.println(Handler.user);
       // Handler.print();
    }
}

class Handler {
    public static User user = new User();
    static {
        System.err.println("static code block");
    }
    {
        System.err.println("code block");
    }
    public Handler(){
        System.err.println("Constructor");
    }
    public static void print(){
        System.err.println("static method");
    }
}

class User {
    public User() {
        System.err.println("user initing===>");
    }
}
