package com.example.demo_test.threadlocal;

/**
 * @author qiwenbo
 * @date 2022/8/18 11:04
 * @Description
 */
public class MyThreadLocal {
    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>() {
        /**
         * ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
         */
        @Override
        protected Object initialValue() {
            System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
            return null;
        }
    };

    public static void main(String[] args) throws InterruptedException {
        new Thread(new MyIntegerTask("IntegerTask1")).start();
        Thread.sleep(20000);
//        new Thread(new MyStringTask("StringTask1")).start();
        new Thread(new MyIntegerTask("IntegerTask2")).start();
//        new Thread(new MyStringTask("StringTask2")).start();
    }

    public static class MyIntegerTask implements Runnable {
        private String name;

        MyIntegerTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("=========thread name=========" + Thread.currentThread().getName());
            for (int i = 0; i < 5; i++) {
                // ThreadLocal.get方法获取线程变量
                if (null == MyThreadLocal.threadLocal.get()) {
                    // ThreadLocal.et方法设置线程变量
                    MyThreadLocal.threadLocal.set(0);
                    System.out.println("线程" + name + ": 0");
                } else {
                    int num = (Integer) MyThreadLocal.threadLocal.get();
                    MyThreadLocal.threadLocal.set(num + 1);
                    System.out.println("线程" + name + ": " + MyThreadLocal.threadLocal.get());
                    if (i == 3) {
                        // 针对 tomcat 服务器设置只有一个线程处理业务代码时，会出现不同用户请求同一个接口，相应的变量混乱，所以每次用完后，必须remove,此外还会导致内存泄漏的问题。
                        MyThreadLocal.threadLocal.remove();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("=========thread name=========" + Thread.currentThread().getName());
        }

    }

    public static class MyStringTask implements Runnable {
        private String name;

        MyStringTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                if (null == MyThreadLocal.threadLocal.get()) {
                    MyThreadLocal.threadLocal.set("a");
                    System.out.println("线程" + name + ": a");
                } else {
                    String str = (String) MyThreadLocal.threadLocal.get();
                    MyThreadLocal.threadLocal.set(str + "a");
                    System.out.println("线程" + name + ": " + MyThreadLocal.threadLocal.get());
                }
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
