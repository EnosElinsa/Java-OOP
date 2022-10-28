package oop.test;

public class TryCatchTest {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        try {
            System.out.println(1 / 0);
            // return;
        } catch(ArithmeticException e) {
            System.out.println("catch code block");
            return;
        } finally {
            System.out.println("finally code block");
            // return;
        }
    }
}

/*
 * 在正常情况（即程序正常执行try catch finally语句块，不会在语句中出现退出程序、线程终止等特殊情况）下，
 * 都会执行finally语句块，如果finally中有return,则程序会走finally中的return，
 * 如果没有，则先执行try或者catch中的return,将其存入临时栈中，执行完finally语句后才返回临时栈中的值。
 */
