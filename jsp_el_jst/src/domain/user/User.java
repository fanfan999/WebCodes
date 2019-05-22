package domain.user;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String name;
    private int age;
    private Date birthday;

    public User() {
    }

    public User(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.birthday = date;
    }
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 逻辑视图
     * @return
     */
    public String getBirStr(){
        String str = null;
        if (birthday != null) {
            //格式化日期对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            //返回字符串
            str = sdf.format(birthday);
        }else {
            str = "";
        }
        return str;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
