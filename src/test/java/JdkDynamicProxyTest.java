import com.chinda.aop.JdkDynamicProxy;
import com.chinda.aop.RealSubject;
import com.chinda.aop.Subject;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author Wang Chinda
 * @date 2020/5/16
 * @see
 * @since 1.0
 */
public class JdkDynamicProxyTest {

    @Test
    public void test() {
        RealSubject realSubject = new RealSubject();
        Subject subjectProxy = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("before to do something!");
            Object result = method.invoke(realSubject, args);
            System.out.println("after to do something!");
            return result;
        });
        subjectProxy.doSomething();
    }

    @Test
    public void test2() {
        RealSubject realSubject = new RealSubject();
        Subject subjectProxy = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), new JdkDynamicProxy(realSubject));
        subjectProxy.doSomething();
    }

    @Test
    public void test3() {
        Subject subjectProxy = (Subject) new JdkDynamicProxy(new RealSubject()).getProxy();
        subjectProxy.doSomething();
    }
}
