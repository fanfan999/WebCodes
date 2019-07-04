package dynamic_proxy;

public class StudentImpl implements Student{
    @Override
    public void study() {
        System.out.println("学生要学习!");
    }

    @Override
    public void eat() {
        System.out.println("学生要吃饭!");
    }
}
