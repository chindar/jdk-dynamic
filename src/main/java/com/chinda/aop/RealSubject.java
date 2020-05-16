package com.chinda.aop;

/**
 * 真正的对象
 *
 * @author Wang Chinda
 * @date 2020/5/16
 * @see
 * @since 1.0
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("realSubject to do something!");
    }
}
