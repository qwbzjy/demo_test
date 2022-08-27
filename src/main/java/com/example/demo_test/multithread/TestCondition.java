package com.example.demo_test.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qiwenbo
 * @date 2022/8/27 14:17
 * @Description
 */
public class TestCondition {
    private int state = 1;
    private Lock lock  =new ReentrantLock();
    private Condition t1Condition = lock.newCondition();
    private Condition t2Condition = lock.newCondition();
    private Condition t3Condition = lock.newCondition();

    public void t1(){
        lock.lock();
        try{
            while (state!=1){
               try{
                   t1Condition.await();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
            }
            System.out.println("now method t1");
            state++;
            t2Condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public void t2(){
        lock.lock();
        try{
            while (state!=2){
                try{
                    t2Condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("now method t2");
            state++;
            t3Condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public void t3(){
        lock.lock();
        try{
            while (state!=3){
                try{
                    t3Condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("now method t3");
            state=1;
            t1Condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TestCondition testCondition = new TestCondition();
        new Thread(()->{
            while (true){
                testCondition.t3();}
        }).start();

        new Thread(()->{
            while (true){
                testCondition.t1();}
        }).start();

        new Thread(()->{
            while (true){
                testCondition.t2();}
        }).start();


    }

}
