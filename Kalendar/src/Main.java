import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String inputDate =  sc.next();
        String[] inputSplited = inputDate.split("/");
        String finalDay = DayOfWeekString(inputDate);
        int day = DayOfWeek(finalDay);
        int mouthNumb = Integer.parseInt(inputSplited[1]);
        int yearNumb = Integer.parseInt(inputSplited[2]);

        YearMonth yearMonthObject = YearMonth.of(yearNumb, mouthNumb);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        System.out.println(daysInMonth);
        int counter = day;
        int dayCounter = 1;
        String filling = StringFill(counter);

        System.out.println("MO DI MI DO FR SA SO");
        for (int i = 0; i < daysInMonth; i++) {
            if(i == 0)
                System.out.print(filling + "");
            if (counter > 6){
                counter = 0;
                System.out.println();
            }
            System.out.printf("%2d ", dayCounter);
            counter++;
            dayCounter++;

        }
    }
    public static int DayOfWeek(String finalDay)
    {
        int day = -1;
        if (finalDay.equals("Monday"))
            day = 0;
        if (finalDay.equals("Tuesday"))
            day = 1;
        if (finalDay.equals("Wednesday"))
            day = 2;
        if (finalDay.equals("Thursday"))
            day = 3;
        if (finalDay.equals("Friday"))
            day = 4;
        if (finalDay.equals("Saturday"))
            day = 5;
        if (finalDay.equals("Sunday "))
            day = 6;

        return day;
    }
    public  static  String DayOfWeekString(String input) throws ParseException {
        String inputDate = input;
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = format1.parse(inputDate);
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay = format2.format(dt1);
        return  finalDay;
    }

    public  static String StringFill(int numb){
        char[] charArray = new char[numb * 3];
        Arrays.fill(charArray, ' ');
        String str = new String(charArray);
        return str;
    }
}
