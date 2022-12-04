package Perfect_Number_507;

import java.util.HashSet;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {


        System.out.println(checkPerfectNumber(28));

    }

    public static boolean checkPerfectNumber(int num) {


        int first = 1;
        for (int i = 2; i <= num/2; i++) {
            if(num%i==0){
                first = i;
                break;
            }
        }
        int last = num/first;
        int sum = last+first+1;
        for (int i = first+1; i < last; i++) {
            if(num%i==0){
                sum= sum+ i+ num/i;
                last = num/i;
            }
        }
        return sum==num;
    }

}
