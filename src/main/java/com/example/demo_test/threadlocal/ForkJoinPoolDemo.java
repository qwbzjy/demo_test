package com.example.demo_test.threadlocal;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author qiwenbo
 * @date 2023/8/9 16:49
 * @Description
 */
public class ForkJoinPoolDemo {
    public static void main(String[] args) {
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long res = forkJoinPool.invoke(new SumTask(array, 0, array.length));
        System.out.println("sum: " + res);
    }

}

class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10000;
    private int[] array;
    private int start;
    private int end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);
            leftTask.fork();
            rightTask.fork();
            long leftRes = leftTask.join();
            long rightRes = rightTask.join();
            return leftRes + rightRes;
        }
    }
}
