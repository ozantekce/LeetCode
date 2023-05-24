package Categorize_Box_According_to_Criteria_2525;

public class Solution {

    public static void main(String[] args) {

        System.out.println(categorizeBox(1000,35,700,300));
        System.out.println(categorizeBox(200,50,800,50));

    }


    public static String categorizeBox(int length, int width, int height, int mass) {

        long volume = length;
        volume*=width;
        volume*=height;

        boolean c1,c2;

        c1 = (volume>= 1000000000) || (length>=10000) || (width>=10000) || (height>=10000);
        c2 = mass>= 100;

        if(c1&&c2)return "Both";
        else if(c1)return "Bulky";
        else if(c2)return "Heavy";
        else return "Neither";
    }

}
