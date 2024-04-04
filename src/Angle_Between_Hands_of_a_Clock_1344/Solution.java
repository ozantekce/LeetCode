package Angle_Between_Hands_of_a_Clock_1344;

public class Solution {

    public static void main(String[] args) {

        System.out.println(angleClock(12,30));
        System.out.println(angleClock(3,30));
        System.out.println(angleClock(3,15));
        System.out.println(angleClock(11,15));

    }


    public static double angleClock(int hour, int minutes) {
        double unit = 360d / 60;
        if(hour == 12)
            hour = 0;
        double h = ((hour + (minutes/60d))) * 5;
        double m = minutes;

        double diff = Math.abs(m - h);
        double diff0 = diff * unit;
        double diff1 = Math.abs(360d - diff0);
        return Math.min(diff0, diff1);
    }

}
