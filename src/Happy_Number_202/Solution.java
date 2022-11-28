package Happy_Number_202;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        System.out.println(isHappy(19));

    }


    public static boolean isHappy(int n) {

        int value = 0;
        List<Integer> history = new ArrayList<>();
        while (true){
            int digit = n%10;
            value += Math.pow(digit,2);
            n/=10;
            if(n==0){
                if(history.contains(value)){
                    return false;
                }
                history.add(value);
                if(value==1){
                    break;
                }
                n = value;
                value = 0;
            }
        }
        return true;
    }

}
