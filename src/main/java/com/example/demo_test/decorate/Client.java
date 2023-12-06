package com.example.demo_test.decorate;

/**
 * @author qiwenbo
 * @date 2023/12/6 9:32
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        //珍珠奶茶
        PearlMilkyTea pearlMilkyTea = new PearlMilkyTea();

        System.out.println("单独买珍珠奶茶价格：" + pearlMilkyTea.cost());

        //加料
        //1.加一份红豆(红豆珍珠奶茶)
        RedBeans redBeansPearlMilkyTea = new RedBeans(pearlMilkyTea);

        System.out.println("珍珠奶茶+红豆：【" + redBeansPearlMilkyTea.getDesc() + "】 价格 ：" + redBeansPearlMilkyTea.cost());

        //2.再加一份布丁
        Pudding pudding = new Pudding(redBeansPearlMilkyTea);

        System.out.println("珍珠奶茶+红豆+布丁：【" + pudding.getDesc() + "】 价格： " + pudding.cost());
    }
}
