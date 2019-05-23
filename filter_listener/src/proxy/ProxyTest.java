package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象类
 */
public class ProxyTest {
    public static void main(String[] args) {
        //创建真实对象
        Lenovo lenovo = new Lenovo();
        //动态代理增强lenovo对象
        /*
        三个参数
            1.类加载器: 真实对象.getClass().getClassLoader()
            2.接口数组: 真实对象.getClass().getInterfaces()
            3.处理器: new InvocationHandler() {}
         */
        //这就是代理对象
        SaleComputer proxyInstance = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
           /*
           代理逻辑编写的方法
            其中代理对象调用的所有方法都会触发该方法执行.
            参数:
                1. proxy: 代理对象,和proxyInstance一样,不怎么用
                2. method: 代理对象调用的方法被封装为的对象,如下面的sale方法,代理对象调用后就被子封装成了method对象
                3. args: 代理对象调用方法时,传递的实际参数.
            */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*System.out.println("这是代理对象中的方法");
                //sale
                System.out.println(method.getName());
                //5000.00
                System.out.println(args[0]);*/

                //使用真实对象调用该方法,这就相当于lenovo调用了sale方法,传递了5000这个参数
                Object invoke = method.invoke(lenovo, args);
                //如果返回是null,所以str输出还是为null,但是sale()方法中的语句会被执行
                //所以输出:花了5000.0钱买的电脑

                //若返回invoke对象,就相当于将invoke对象传递给了str,而invoke对象存储的是sale方法的返回值
                //所以就相当于真实对象直接调用方法
                //这么写下来,我们就会发现,这个和真实对象直接调用方法的逻辑和输出完全一样
                return invoke;
            }
        });
        //调用方法
        String str = proxyInstance.sale(5000);
        System.out.println(str);
    }
}
