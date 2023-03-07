public class Calculate_Money_in_Leetcode_Bank_1716 {


    public static void main(String[] args) {


        System.out.println(totalMoney(4));
        System.out.println(totalMoney(10));
        System.out.println(totalMoney(20));

    }


    public static int totalMoney(int n) {
        int week = n/7;
        int remainderDays = n%7;

        int lastWeekStart = n/7 + 1;

        int firstWeek = 28;
        int res = (week*firstWeek) + (7*week*(week-1))/2
                + (lastWeekStart + (lastWeekStart+remainderDays-1)) * (remainderDays)/2;

        return res;
    }




}
