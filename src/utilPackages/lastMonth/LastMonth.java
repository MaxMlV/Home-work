package utilPackages.lastMonth;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LastMonth {
    public static void main(String[] args) {
        Calendar currentDate = Calendar.getInstance();
        Calendar lastMonth = Calendar.getInstance();
        lastMonth.set(Calendar.MONTH,lastMonth.get(Calendar.MONTH)-1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");

        Date currentDateTime = currentDate.getTime();
        Date lastMonthTime = lastMonth.getTime();

        long timeInMilS = currentDateTime.getTime() - lastMonthTime.getTime();
        System.out.println(timeInMilS + " milliseconds since current date.");
    }
}
