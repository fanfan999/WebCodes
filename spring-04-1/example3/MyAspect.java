package example3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类,注解配置该对象只能通过component
 *  如果这里@Component("myAspect")有id的话,@Aspect这个注解有没有都可以
 *  如果@Component()没有id的话,@Aspect这个注解必须有,通过这个区告诉xml这个类是切面类
 */
@Component("myAspect")
@Aspect
public class MyAspect {
    /**
     * 声明一个方法作为公共的切入点
     */
    @Pointcut("execution(* example3.service.User.add*(..))")
    public void myPointCut() {

    }

    /**
     * 注解里面放切入点的引用或者切入点表达式
     * 即:@Before("execution(* example3.service.User.add*(..))")
     * 也等于@Before("myPointCut()")
     */
    @Before("myPointCut()")
    public void before() {

        System.out.println("前置通知!");
    }

    /**
     * 后置通知获取业务方法(这里就是service方法)执行后的返回值
     * 对比
     * @param jp 这个可有可没有,这个应该叫做连接点
     *           其实就是expression后面的值,其name就是调用的方法名
     * @param retValue 这个可有可没有,
     */
    @AfterReturning(pointcut = "myPointCut()",returning = "retValue")
    public void afterReturning(JoinPoint jp, Object retValue) {

        System.out.println("后置通知,其返回值为" + retValue);
    }

    /**
     *
     * @param pjp 参数表示连接点,也就是切入点,就是增强代码作用的方法
     * @throws Throwable
     */
    @Around("myPointCut()")
    public int myAround(ProceedingJoinPoint pjp) throws Throwable {

        //pjp其实就是expression后面那一串表达式
        System.out.println("环绕通知_提交事务" + pjp);
        //放行
        Object o = pjp.proceed();

        //获取其方法名就等于切入的方法的名字
        System.out.println("环绕通知_关闭事务" + pjp.getSignature().getName() + "返回值为:" + o);

        //这里的正确写法应该是
        return (int) o;
        //这个是为了测试说明,如果后置通知和环绕通知一起存在,后置通知的返回值接收的是环绕通知返回的.
        //return 100;
    }

    /**
     *jp 调用方法的时候,都会传过来一个连接点
     *   也是expression后面的式子,名称就是切入的方法名
     *   可写可不写
     * @param jp 对比环绕通知的pjp,这个没有放行功能
     * @param e
     */
    @AfterThrowing(pointcut = "myPointCut()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Throwable e) {

        System.out.println("抛出异常通知" + e.getMessage());
    }

    /**
     * 最终通知
     * @param jp 这个所有通知方法都可以写也可以不写
     */
    @After("myPointCut()")
    public void after(JoinPoint jp) {

        System.out.println("最终通知" + jp.getSignature().getName());

    }
}
