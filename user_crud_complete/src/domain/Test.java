package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        AnoUser user1 = new AnoUser("fan1",11);
        AnoUser user2 = new AnoUser("fan1",11);
        AnoUser user3 = new AnoUser("fan1",11);

        Map<String, AnoUser> map = new HashMap<>();
        map.put("u1", user1);
        map.put("u2", user2);
        map.put("u3", user3);

        System.out.println(map);

        Map<String, String> map1 = new HashMap<>();
        map1.put("u1","user1");
        map1.put("u2","user1");
        map1.put("u3", "user1");

        System.out.println(map1);

        List<AnoUser> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        System.out.println(list);


    }


}
