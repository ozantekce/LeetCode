package Self_Dividing_Numbers_728;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(selfDividingNumbers(1,22));

    }


    public static List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if(selfDividingNumber(i)){
                list.add(i);
            }
        }

        return list;
    }

    public static boolean selfDividingNumber(int num){

        if(num==0)
            return false;
        int recordNum = num;
        while (num>0){
            int digit = num%10;
            if(digit==0 || recordNum%digit!=0){
                return false;
            }
            num/=10;
        }
        return true;

    }


}
