package com.chinda.aop;

import com.chinda.aop.interceptor.TimerInterceptor;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Wang Chinda
 * @date 2020/5/16
 * @see
 * @since 1.0
 */
@AllArgsConstructor
public class JdkDynamicProxy implements AopProxy, InvocationHandler {
    /**
     * 被代理类
     */
    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        return timerInterceptor.invoke(new ReflectiveMethodInvocation(target, method, args));
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
