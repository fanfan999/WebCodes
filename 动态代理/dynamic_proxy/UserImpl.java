package dynamic_proxy;

public class UserImpl implements User{
    /**
     * 我希望在添加前来一个权限校验,添加后来一个日志记录
     *
     * 我们可以修改我们的源码实现,但是这样不好
     *  1. 这个权限校验和日志记录和我们这个功能方法本来没啥关系,它不属于这个功能
     *  2. 我们不断修改源码,而且还是重复的东西,费时费力
     *
     * 正确的做法:
     *  我们应该请别人来做,另外生成一个类来专门做这个功能,就不会重复写好多回,也不会修改源码了.
     */
    @Override
    public void add() {
        //System.out.println("权限校验");
        System.out.println("添加了一个学生!");
        //System.out.println("记录日志");
    }

    @Override
    public void delete() {
        //System.out.println("权限校验");
        System.out.println("删除了一个学生!");
        //System.out.println("记录日志");
    }
}
