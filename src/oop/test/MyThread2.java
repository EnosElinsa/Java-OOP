package oop.test;

public class MyThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "at MyThread2");
        }
    }
    
    public static void main(String[] args) {
        new Thread(new MyThread2()).start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "at main thread");
        }
    }
}
