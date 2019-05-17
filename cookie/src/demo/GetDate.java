package demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
    public static void main(String[] args) {
        /*Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String time = dateFormat.format(date);
        System.out.println(time);*/
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd hh:MM:ss";
        String strDateFormat1 = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        SimpleDateFormat sdf1 = new SimpleDateFormat(strDateFormat1);
        System.out.println(sdf.format(date));
        System.out.println(sdf1.format(date));
    }

}
