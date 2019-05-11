package test;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {

    @Test
    public void test() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        BeanUtils.setProperty(user,"name", "fan");
        System.out.println(user);
        String name = BeanUtils.getProperty(user, "name");
        System.out.println(name);
    }


}
