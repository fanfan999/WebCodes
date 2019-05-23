package proxy;

/**
 * 真实类
 */
public class Lenovo implements SaleComputer{
    @Override
    public String sale(double money) {
        System.out.println("代理商花了" + money + "元钱从厂商进的电脑");

        return "买家获得了联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑");
    }
}
