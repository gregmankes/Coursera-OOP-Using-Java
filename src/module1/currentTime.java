package module1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class currentTime {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        System.out.println( sdf.format(cal.getTime()) );
    }

}