package Day_of_the_Week_1185;

public class Solution {

    public static void main(String[] args) {

        System.out.println(dayOfTheWeek(31,8,2019));
        System.out.println(dayOfTheWeek(18,7,1999));
        System.out.println(dayOfTheWeek(15,8,1993));
        System.out.println(dayOfTheWeek(29,2,2016));
        System.out.println(dayOfTheWeek(1,2,2014));

    }

    public static String dayOfTheWeek(int day, int month, int year) {

        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        year--;
        int total = (year/4)*366+(year-year/4)*365 -1;
        year++;
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(year%4==0 && year!=2100){
            months[1] = 29;
        }
        for(int i=0;i<month-1;i++){
            total+= months[i];
        }
        total +=day;
        return week[total%7];
    }

}
