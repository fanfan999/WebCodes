package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * 增强对象
 */
public class ProxyTest1 {
    public static void main(String[] args) {
        //创建真实对象
        Lenovo lenovo = new Lenovo();


        //动态代理增强lenovo对象,这就是代理对象
        SaleComputer proxyInstance = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //money的默认值为传来的参数
                double money = (double) args[0];


                //1.增强参数,比如说我们这里只需要增强sale方法,不用增强show方法
                //判断是否是sale方法,是就增强
                if (method.getName().equals("sale")) {
                    //如果是代理商,那么它只给厂商0.85的钱,它得0.15的钱
                    money = money * 0.85;
                    System.out.println("代理商专车接你.......");

                    //使用真实对象调用该方法,这就相当于lenovo调用了sale方法,传递了money这个参数
                    //如果是代理,money的实际进货价格就是原来的0.85,如果不是代理,那就还是原来的
                    //但是我用户掏的钱还是5000一分没少,所以代理商赚差价就是这么来的
                    String invoke = (String) method.invoke(lenovo, money);
                    System.out.println("代理商免费送货...");

                    //2. 增强返回值,由于代理商赚了太多的钱,怕你知道了不爽,就送点小礼品
                    invoke = invoke + "和联想平板";

                    //3. 增强方法体,就像上面的专车接送一样
                    return invoke;
                }else {
                    String invoke = (String) method.invoke(lenovo, money);

                    return invoke;
                }

            }
        });
        //调用方法
        String str = proxyInstance.sale(5000);
        System.out.println(str);
    }
}
