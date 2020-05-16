package com.chinda.aop;

import lombok.AllArgsConstructor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * @author Wang Chinda
 * @date 2020/5/16
 * @see
 * @since 1.0
 */
@AllArgsConstructor
public class ReflectiveMethodInvocation implements MethodInvocation {

    private Object target;
    private Method method;
    private Object[] args;

    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public Object[] getArguments() {
        return this.args;
    }

    @Override
    public Object proceed() throws Throwable {
        return this.method.invoke(this.target, this.args);
    }

    @Override
    public Object getThis() {
        return this.target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return this.method;
    }
}
