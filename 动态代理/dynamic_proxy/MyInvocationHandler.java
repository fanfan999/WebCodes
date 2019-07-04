package dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 调用处理程序
 */
public class MyInvocationHandler implements InvocationHandler {

    /**
     * 因为要通过我这个调用处理程序来调用invoke方法实现动态代理,
     * 所以参数需要在创建对象的时候传进来,构造方法的时候传进来再合适不过了
     */

    private Object obj;

    //obj就是被代理对象
    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    /**
     *
     * @param proxy 被代理对象
     * @param method 被代理对象需要执行的方法,即user里的add和delete方法
     * @param args 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //在这里进行权限校验这些东西,然后再调用方法,是不是就达到了想要的效果
        System.out.println("权限校验!");

        //通过反射执行方法,即proxy对象也就是上面的obj对象调用参数列表为args的method方法
        method.invoke(obj, args);

        //日志记录
        System.out.println("日志记录!");

        return null;
    }
}
