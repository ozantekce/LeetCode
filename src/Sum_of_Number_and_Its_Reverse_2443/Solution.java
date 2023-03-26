package Sum_of_Number_and_Its_Reverse_2443;

import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

        System.out.println(sumOfNumberAndReverse(443)); //true
        System.out.println(sumOfNumberAndReverse(63));  //false
        System.out.println(sumOfNumberAndReverse(181)); //true
        System.out.println(sumOfNumberAndReverse(0));   //true
        System.out.println(sumOfNumberAndReverse(10));  //true


    }


    public static boolean sumOfNumberAndReverse(int num) {
        if(num==0)return true;
        for (int i = num/2; i < num; i++) {

            int val = i;
            int sum = val + reverse(val);
            if(sum==num)return true;
        }
        return false;
    }

    public static int reverse(int num){
        int reversed = 0;
        while (num>0){
            reversed*=10;
            reversed+= num%10;
            num/=10;
        }
        return reversed;
    }


}
