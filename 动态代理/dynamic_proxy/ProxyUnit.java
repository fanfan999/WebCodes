package dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * 测试类
 */
public class ProxyUnit {
    public static void main(String[] args) {
        //直接调用方法,没有权限校验和日志记录
        User user = new UserImpl();
        user.add();
        user.delete();
        System.out.println("---------------");
        /**
         * 通过动态代理实现权限校验和日志记录
         * 这里获取字节码文件可只能通过对象.getClass()
         */
        User u = (User) Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), new MyInvocationHandler(user));
        //这个u就是代理对象,不是User对象,我们这里通过代理对象u调用方法
        u.add();
        u.delete();
        System.out.println("---------------");

        /**
         * 学生类动态代理案例
         */
        Student student = new StudentImpl();
        //不使用动态代理调用方法,没有权限校验和日志记录
        student.study();
        student.eat();
        System.out.println("---------------");

        //通过动态代理实现权限校验和日志记录
        Student s = (Student) Proxy.newProxyInstance(student.getClass().getClassLoader(), student.getClass().getInterfaces(), new MyInvocationHandler(student));

        s.eat();
        s.study();
    }
}
