package com.example.demo_test.dynamicproxy.cglib;

import com.example.demo_test.dynamicproxy.jdk.PersonEAT;
import net.sf.cglib.proxy.Enhancer;

import java.sql.SQLException;

/**
 * @author qiwenbo
 * @date 2022/8/19 14:57
 * @Description cglib动态代理
 */
public class PersonProxyTest {
    public static void main(String[] args) throws SQLException {
        PersonProxy daoProxy = new PersonProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonEAT.class);
        enhancer.setCallback(daoProxy);
        PersonEAT dt = (PersonEAT) enhancer.create();
        dt.eat();
    }
}
