package Ugly_Number_263;

public class Solution {

    public static void main(String[] args) {


        System.out.println(isUgly(14));

    }


    public static boolean isUgly(int n) {

        if(n==0)
            return false;

        while (true){
            if(n==1||n==2||n==3||n==5){
                return true;
            }
            if(n%2==0){
                n/=2;
            }else if(n%3==0){
                n/=3;
            }else if(n%5==0){
                n/=5;
            }else{
                return false;
            }
        }
    }

}
