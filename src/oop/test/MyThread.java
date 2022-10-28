package oop.test;

public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        myThread.start();

        for (int i = 50; i < 100; i++) {
            System.out.println(i);
        }
    }
}
