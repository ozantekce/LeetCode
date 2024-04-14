package Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers_1689;

public class Solution {

    public static void main(String[] args) {

        System.out.println(minPartitions("32"));
        System.out.println(minPartitions("82734"));
        System.out.println(minPartitions("27346209830709182346"));

    }



    public static int minPartitions(String n) {

        for (char i = 57; i >= 48; i--) {
            if(n.contains(i+"")){
                return i - 48;
            }
        }

        return 0;
    }

}
