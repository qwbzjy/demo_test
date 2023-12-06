package com.example.demo_test.adapter;

/**
 * @author qiwenbo
 * @date 2023/12/6 9:59
 * @Description
 */
public class AdapterMain {
    public static void main(String[] args) {
        Param2 param2=new Param2Impl();
        Adapter adapter = new Adapter(param2);
        work(adapter);
    }

    public static void work(Param1 param1) {
        System.out.println("准备开始干活");
        param1.doingThings();
        System.out.println("干完活了");
    }


}
interface Param1{
    void doingThings();
}
class Param1Impl implements Param1{
    @Override
    public void doingThings() {
        System.out.println("我正在干活");
    }
}

interface Param2 {
    void doingThings();
}
class Param2Impl implements Param2 {

    @Override
    public void doingThings() {
        System.out.println("Param2正在干活");
    }
}
class Adapter implements Param1{

    private Param2 param2;

    public Adapter(Param2 param2) {
        this.param2 = param2;
    }

    @Override
    public void doingThings() {
        param2.doingThings();
    }
}

